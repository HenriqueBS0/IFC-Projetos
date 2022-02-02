<?php

namespace HenriqueBS0\Keep\Controllers;

use HenriqueBS0\Keep\Models\UsuarioEntidade;

class AcessoController {

    public function home(): void
    {
        view('acesso/home', [], [public_path('css/acesso/home.css')]);
    }

    public function entrarView() {
        view('acesso/entrar', [public_path('js/acesso/entrar/main.js')], [public_path('css/acesso/entrar.css')]);
    }

    public function entrar() {
        $email = isset($_POST['email']) ? $_POST['email'] : null;
        $senha = isset($_POST['senha']) ? $_POST['senha'] : null;

        if(!ValidacoesController::validarCredenciais($email, $senha)) {
            sessao('credenciaisInvalidas', 'Credenciais inválidas.');
            redirecionar('entrar');
            return;
        }

        deletaDadoSessao('credenciaisInvalidas');

        $usuario = (new UsuarioEntidade())
            ->select()
            ->where(['email', "'{$email}'"])
            ->first();

        $this->logar($usuario->id);
        redirecionar('notas');
    }

    public function cadastrarView() {
        view('acesso/cadastrar', [public_path('js/acesso/cadastrar/main.js')], [public_path('css/acesso/cadastrar.css')]);
    }

    public function cadastrar() {
        $nome  = isset($_POST['nome'])  ? $_POST['nome']  : 'ADM ADM';
        $senha = isset($_POST['senha']) ? $_POST['senha'] : '123456';
        $email = isset($_POST['email']) ? $_POST['email'] : null;

        if(!ValidacoesController::emailValido($email)) {
            sessao('credenciaisInvalidas', 'Email inválido');
            redirecionar('cadastrar');
            return;
        }

        if(ValidacoesController::emailUtilizado($email)) {
            sessao('credenciaisInvalidas', 'O email informado já foi cadastrado.');
            redirecionar('cadastrar');
            return;
        }

        deletaDadoSessao('credenciaisInvalidas');

        $usuario = new UsuarioEntidade();
        $usuario->nome = $nome;
        $usuario->email = $email;
        $usuario->senha = password_hash($senha, PASSWORD_DEFAULT);

        $usuario->insert();

        $this->logar($usuario->id);
        redirecionar('notas');
    }

    public function sair() {
        $this->deslogar();
        redirecionar('entrar');
    }

    private function logar(int $idUsuario) {
        sessao('logado', true);
        sessao('idUsuario', $idUsuario);
    }

    private function deslogar() {
        sessao('logado', false);
        deletaDadoSessao('idUsuario');
    }
}