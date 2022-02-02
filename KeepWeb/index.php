<?php

require_once __DIR__ . '/vendor/autoload.php';

use HenriqueBS0\Router\Router;
use HenriqueBS0\Keep\Routes\RotasUso;
use HenriqueBS0\Keep\Routes\RotasAcesso;
use HenriqueBS0\Keep\Routes\RotasService;

$router = new Router();

$router->addRoutesGroup(RotasAcesso::class);
$router->addRoutesGroup(RotasUso::class);
$router->addRoutesGroup(RotasService::class);

$router->resolve();




































// use HenriqueBS0\Keep\Models\EnderecoEntidade;
// use HenriqueBS0\Keep\Models\NotaEntidade;
// use HenriqueBS0\Keep\Models\NotaHasRotuloEntidade;
// use HenriqueBS0\Keep\Models\RotuloEntidade;
// use HenriqueBS0\Keep\Models\UsuarioEntidade;

// $usuario = new UsuarioEntidade;
// $henrique = $usuario->select()->where(['nome', 'LIKE', "'Henrique%'"])->first();

// $nota1 = (new NotaEntidade)->select()->where(['id', 1])->first();
// $rotulo1 = (new RotuloEntidade)->select()->where(['id', 1])->first();

// var_dump($rotulo1->notas());

// // var_dump($nota1->rotulos());

// // $endereco = new EnderecoEntidade();
// // $susana = new UsuarioEntidade();
// // $nota = new NotaEntidade();
// // $rotulo = new RotuloEntidade();
// // $notaHasRotulo = new NotaHasRotuloEntidade();

// // $endereco->pais = 'Brasil';
// // $endereco->estado = 'Santa Catarina';
// // $endereco->cidade = 'Rio do Sul';
// // $endereco->bairro = 'Canoas';
// // $endereco->rua = 'Joinville';
// // $endereco->numero = 155;
// // $endereco->insert();

// // $susana->nome = 'Susana Borges dos Santos';
// // $susana->email = 'susana.@gmail.com';
// // $susana->senha = '123456';
// // $susana->idEndereco = $endereco->id;
// // $susana->insert();

// // $rotulo->descricao = 'Academico';
// // $rotulo->insert();

// // $nota->titulo = 'Apresentacao TCC';
// // $nota->data = '2021-12-02';
// // $nota->hora = '16:00:00';
// // $nota->descricao = 'Apresentação do meu tcc no IFC';
// // $nota->idUsuario = $susana->id;
// // $nota->insert();

// // $notaHasRotulo->idNota = $nota->id;
// // $notaHasRotulo->idRotulo = $rotulo->id;
// // $notaHasRotulo->insert();