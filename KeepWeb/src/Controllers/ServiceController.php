<?php

namespace HenriqueBS0\Keep\Controllers;

use HenriqueBS0\Keep\Models\EnderecoEntidade;
use HenriqueBS0\Keep\Models\ImagemEntidade;
use HenriqueBS0\Keep\Models\NotaEntidade;
use HenriqueBS0\Keep\Models\NotaHasRotuloEntidade;
use HenriqueBS0\Keep\Models\RotuloEntidade;
use HenriqueBS0\Keep\Models\UsuarioEntidade;
use stdClass;

class ServiceController {

    const STATUS_OK   = 'ok';
    const STATUS_ERRO = 'erro';

    private bool $gerouResposta = false;

    private array $resposta = [
        'status' => self::STATUS_OK,
        'mensagens' => [],
        'dados'  => []
    ];

    private function setStatusOK(): void
    {
        $this->gerouResposta = true;
        $this->resposta['status'] = self::STATUS_OK;
    }

    private function setStatusErro(): void
    {
        $this->gerouResposta = true;
        $this->resposta['status'] = self::STATUS_ERRO;
    }

    private function addMensagens(string|array $mensagens, string|null $identificador = null): void
    {
        $this->gerouResposta = true;
        if(is_string($mensagens)) {
            if(is_string($identificador)) {
                $this->resposta['mensagens'][$identificador] = $mensagens;
            }
            else {
                $this->resposta['mensagens'][] = $mensagens;
            }
            return;
        }

        foreach ($mensagens as $mensagem) {
            $this->addMensagens($mensagem, $identificador);
        }
    }

    private function addDado($dado, null|string $identificador = null): void
    {
        $this->gerouResposta = true;
        if(is_string($identificador)) {
            $this->resposta['dados'][$identificador] = $dado;
            return;
        }
        $this->resposta['dados'][] = $dado;
    }

    private static function getUsuarioLogado(): UsuarioEntidade
    {
        return (new UsuarioEntidade())
            ->select()
            ->where(['id', sessao('idUsuario')])
            ->first();
    }

    public function __destruct()
    {
        if(!$this->gerouResposta) {
            return;
        }

        header('Content-Type: application/json');
        echo json_encode($this->resposta);
    }

    public function validarDadosEntrar() {
        $camposValidos = true;

        $email = isset($_POST['email']) ? $_POST['email'] : null;
        $senha = isset($_POST['senha']) ? $_POST['senha'] : null;

        $validacao = ValidacoesController::validarCampoEmail($email);
        if(!$validacao->valido) {
            $this->addMensagens($validacao->mensagens, 'email');
            $camposValidos = false;
        }

        $validacao = ValidacoesController::validarCampoSenha($senha);
        if(!$validacao->valido) {
            $this->addMensagens($validacao->mensagens, 'senha');
            $camposValidos = false;
        }

        if(!$camposValidos) {
            $this->setStatusErro();
            return;
        }

        if(!ValidacoesController::validarCredenciais($email, $senha)) {
            $this->addMensagens('Credenciais inválidas.', 'credenciais');
            $this->setStatusErro();
            return;
        }

        $this->setStatusOK();
    }

    public function validarDadosCadastrar() {

        $camposValidos = true;

        $nome  = isset($_POST['nome'])  ? $_POST['nome']  : null;
        $email = isset($_POST['email']) ? $_POST['email'] : null;
        $senha = isset($_POST['senha']) ? $_POST['senha'] : null;

        $validacao = ValidacoesController::validarCampoNome($nome);
        if(!$validacao->valido) {
            $this->addMensagens($validacao->mensagens, 'nome');
            $camposValidos = false;
        }

        $validacao = ValidacoesController::validarCampoEmail($email);
        if(!$validacao->valido) {
            $this->addMensagens($validacao->mensagens, 'email');
            $camposValidos = false;
        }

        $validacao = ValidacoesController::validarCampoSenha($senha);
        if(!$validacao->valido) {
            $this->addMensagens($validacao->mensagens, 'senha');
            $camposValidos = false;
        }

        if(!$camposValidos) {
            $this->setStatusErro();
            return;
        }

        if(ValidacoesController::emailUtilizado($email)) {
            $this->addMensagens('O email informado já foi cadastrado.', 'credenciais');
            $this->setStatusErro();
            return;
        }

        $this->setStatusOK();
    }

    public function getRotulos() {
        $this->setStatusOK();

        foreach (self::getUsuarioLogado()->rotulos() as $rotulo) {
            $this->addDado([
                'id'        => $rotulo->id,
                'descricao' => $rotulo->descricao
            ]);
        }
    }

    public function salvarRotulos() {
        $dadosRotulos = json_decode($_POST['rotulos']);
        $idsRotulos = [];

        foreach ($dadosRotulos as $dadosRotulo) {
            $rotulo = new RotuloEntidade();
            $rotulo->idUsuario = sessao('idUsuario');
            $rotulo->descricao = $dadosRotulo->descricao;

            if(isset($dadosRotulo->novo)) {
                $rotulo->insert();
            }
            else {
                $rotulo->id = $dadosRotulo->id;
                $rotulo->update();
            }

            $idsRotulos[] = $rotulo->id;
        }

        $codicaoRotulos = count($idsRotulos) > 0
            ? " AND id NOT IN (" . implode(',', $idsRotulos) . ")"
            : '';

        $rotulosParaExcluir = (new RotuloEntidade())
            ->select()
            ->where("idUsuario = ".sessao('idUsuario')."{$codicaoRotulos}")
            ->fetch();

        foreach ($rotulosParaExcluir as $rotulo) {
            $rotulo->delete();
        }

        $this->getRotulos();
    }

    public function getNotas() {
        $this->setStatusErro();

        $condicoes = [];

        $condicoes[] = 'idUsuario = '.sessao('idUsuario');

        $filtros = json_decode($_POST['filtros']);

        if($filtros->buscar) {
            $condicoes[] = "titulo LIKE '{$filtros->buscar}%'";
        }

        if($filtros->dataInicial) {
            $condicoes[] = "(dataCriacao >= '{$filtros->dataInicial}' OR dataAlteracao >= '{$filtros->dataInicial}')";
        }

        if($filtros->dataFinal) {
            $condicoes[] = "(dataCriacao <= '{$filtros->dataFinal}' OR dataAlteracao <= '{$filtros->dataFinal}')";
        }

        if($filtros->horaInicial) {
            $condicoes[] = "(time(dataCriacao) >= '{$filtros->horaInicial}' OR time(dataAlteracao) >= '{$filtros->horaInicial}')";
        }

        if($filtros->horaFinal) {
            $condicoes[] = "(time(dataCriacao) <= '{$filtros->horaFinal}' OR time(dataAlteracao) <= '{$filtros->horaFinal}')";
        }

        $condicoes = implode(' AND ', $condicoes);

        $notas = (new NotaEntidade)
                ->select()
                ->where($condicoes)
                ->fetch();

        if($filtros->rotulo) {
            $notas = self::filtrarNotasPorRotulo($notas, $filtros->rotulo);
        }

        foreach ($notas as $nota) {
            $dadosNota = new stdClass();
            $dadosNota->id = $nota->id;
            $dadosNota->titulo = $nota->titulo;
            $dadosNota->descricao = $nota->descricao;
            $dadosNota->cor = $nota->cor;

            $this->addDado($dadosNota);
        }

        return $this->setStatusOK();
    }

    private static function filtrarNotasPorRotulo($notas, $idRotulo) {
        $notasFiltradas = [];
        foreach ($notas as $nota) {
            if(self::notaRotuloAssociados($nota->id, $idRotulo)) {
                $notasFiltradas[] = $nota;
            }
        }

        return $notasFiltradas;
    }

    private static function notaRotuloAssociados($idNota, $idRotulo) {
        return (new NotaHasRotuloEntidade)
            ->select()
            ->where("idNota = {$idNota} AND idRotulo = {$idRotulo}")
            ->exists();
    }

    public function criarImagem() {
        $imagem = $_FILES['imagem'];

        $time = time();
        $nome = $time;

        move_uploaded_file($imagem['tmp_name'], PROJECT_PATH . "public/img/notas/{$nome}.png");

        $imagens = existeNaSessao('imagens') ? sessao('imagens') : [];
        $imagens[$time] = "{$nome}.png";

        sessao('imagens', $imagens);

        $this->addDado($time, 'id');
        $this->addDado("{$nome}.png", 'caminho');
        $this->setStatusOK();
    }

    public function destruirImagensSession() {
        foreach (sessao('imagens') as $imagem) {
            deletarImagem($imagem);
        }

        deletaDadoSessao('imagens');

        $this->setStatusOK();
    }

    public function criarNota() {
        $dados = json_decode($_POST['dados']);

        $nota = new NotaEntidade();
        $nota->idUsuario = sessao('idUsuario');
        $nota->titulo = $dados->titulo;
        $nota->descricao = $dados->descricao;
        $nota->cor = $dados->cor;
        $nota->dataCriacao = date('Y-m-d H:i:s');
        $nota->dataAlteracao = date('Y-m-d H:i:s');
        $nota->insert();

        foreach ($dados->rotulos as $idRotulo) {
            $associativa = new NotaHasRotuloEntidade();
            $associativa->idNota = $nota->id;
            $associativa->idRotulo = $idRotulo;
            $associativa->insert();
        }

        foreach ($dados->imagens as $dadosImagem) {
            $imagens = sessao('imagens');
            unset($imagens[$dadosImagem->id]);
            sessao('imagens', $imagens);

            $imagem = new ImagemEntidade();
            $imagem->idNota = $nota->id;
            $imagem->caminho = $dadosImagem->caminho;
            $imagem->insert();
        }

        $this->setStatusOK();
    }

    public function getDadosNota() {
        $id = $_POST['id'];

        $nota = (new NotaEntidade())
            ->select()
            ->where(['id', $id])
            ->first();

        $imagens = [];

        foreach ($nota->imagens() as $imagem) {
            $imagemObj = new stdClass();
            $imagemObj->id = $imagem->id;
            $imagemObj->caminho = $imagem->caminho;
            $imagens[] = $imagemObj;
        }

        $rotulos = [];

        foreach ($nota->rotulos() as $dadosRotulo) {
            $rotulo = new stdClass();
            $rotulo->id = $dadosRotulo->id;
            $rotulo->descricao = $dadosRotulo->descricao;
            $rotulos[] = $rotulo;
        }

        $this->addDado($nota->id, 'id');
        $this->addDado($nota->titulo, 'titulo');
        $this->addDado($nota->descricao, 'descricao');
        $this->addDado($nota->dataCriacao, 'dataCriacao');
        $this->addDado($nota->dataAlteracao, 'dataAlteracao');
        $this->addDado($nota->cor, 'cor');
        $this->addDado($imagens, 'imagens');
        $this->addDado($rotulos, 'rotulos');
        $this->setStatusOK();
    }

    public function excluirNota() {
        $id = $_POST['id'];
        $nota = (new NotaEntidade())
            ->select()
            ->where(['id', $id])
            ->first();

        $nota->delete();

        $this->setStatusOK();
    }

    public function alterarNota() {
        $dados = json_decode($_POST['dados']);

        $nota = (new NotaEntidade())
            ->select()
            ->where(['id', $dados->id])
            ->first();
        $nota->titulo = $dados->titulo;
        $nota->descricao = $dados->descricao;
        $nota->cor = $dados->cor;
        $nota->dataAlteracao = date('Y-m-d H:i:s');
        $nota->update();

        (new NotaHasRotuloEntidade)->where(['idNota', $nota->id])->delete();

        foreach ($dados->rotulos as $idRotulo) {
            $associativa = new NotaHasRotuloEntidade();
            $associativa->idNota = $nota->id;
            $associativa->idRotulo = $idRotulo;
            $associativa->insert();
        }

        (new ImagemEntidade)->where(['idNota', $nota->id])->delete();

        foreach ($dados->imagens as $dadosImagem) {
            $imagens = sessao('imagens');
            unset($imagens[$dadosImagem->id]);
            sessao('imagens', $imagens);

            $imagem = new ImagemEntidade();
            $imagem->idNota = $nota->id;
            $imagem->caminho = $dadosImagem->caminho;
            $imagem->insert();
        }

        $this->setStatusOK();
    }

    public function getDadosUsuario() {
        $usuario = (new UsuarioEntidade)
            ->select()
            ->where(['id', sessao('idUsuario')])
            ->first();

        $this->addDado($usuario->nome, 'nome');
        $this->addDado($usuario->email, 'email');
        $this->setStatusOK();
    }

    public function alterarUsuario() {
        $usuario = (new UsuarioEntidade)
            ->select()
            ->where(['id', sessao('idUsuario')])
            ->first();

        $usuario->nome = $_POST['nome'];
        $usuario->email = $_POST['email'];
        $usuario->senha = strlen($_POST['senha']) > 0 ? password_hash($_POST['senha'], PASSWORD_DEFAULT) : $usuario->senha;
        $usuario->update();
        $this->setStatusOK();
    }

    public function getDadosEndereco() {
        $pais   = '';
        $estado = '';
        $cidade = '';
        $bairro = '';
        $rua    = '';
        $numero = null;

        if(self::temEndereco()) {
            $endereco = (new EnderecoEntidade)
                ->select()
                ->where(['idUsuario', sessao('idUsuario')])
                ->first();

            $pais   = $endereco->pais;
            $estado = $endereco->estado;
            $cidade = $endereco->cidade;
            $bairro = $endereco->bairro;
            $rua    = $endereco->rua;
            $numero = $endereco->numero;
        }

        $this->addDado($pais, 'pais');
        $this->addDado($estado, 'estado');
        $this->addDado($cidade, 'cidade');
        $this->addDado($bairro, 'bairro');
        $this->addDado($rua, 'rua');
        $this->addDado($numero, 'numero');
        $this->setStatusOK();
    }

    public function salvarEndereco() {
        $endereco = new EnderecoEntidade;

        if(self::temEndereco()) {
            $endereco = $endereco
                ->select()
                ->where(['idUsuario', sessao('idUsuario')])
                ->first();
        }

        $endereco->pais = $_POST['pais'];
        $endereco->estado = $_POST['estado'];
        $endereco->cidade = $_POST['cidade'];
        $endereco->bairro = $_POST['bairro'];
        $endereco->rua = $_POST['rua'];
        $endereco->numero = $_POST['numero'];

        if(self::temEndereco()) {
            $endereco->update();
        }
        else {
            $endereco->insert();
        }

        $this->setStatusOK();
    }

    private static function temEndereco() {
        return (new EnderecoEntidade)
            ->select()
            ->where(['idUsuario', sessao('idUsuario')])
            ->exists();
    }
}