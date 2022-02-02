<?php

namespace HenriqueBS0\Keep\Routes;

use HenriqueBS0\Keep\Controllers\ServiceController;
use HenriqueBS0\Router\RoutesGroup;
class RotasService extends RoutesGroup
{
    protected function setRoutes(): void
    {
        $this->group('/service');

        $this->post('/validarDadosEntrar', [ServiceController::class, 'validarDadosEntrar']);
        $this->post('/validarDadosCadastrar', [ServiceController::class, 'validarDadosCadastrar']);
        $this->post('/getRotulos', [ServiceController::class, 'getRotulos']);
        $this->post('/salvarRotulos', [ServiceController::class, 'salvarRotulos']);
        $this->post('/getNotas', [ServiceController::class, 'getNotas']);
        $this->post('/criarImagem', [ServiceController::class, 'criarImagem']);
        $this->post('/destruirImagensSession', [ServiceController::class, 'destruirImagensSession']);
        $this->post('/criarNota', [ServiceController::class, 'criarNota']);
        $this->post('/getDadosNota', [ServiceController::class, 'getDadosNota']);
        $this->post('/excluirNota', [ServiceController::class, 'excluirNota']);
        $this->post('/alterarNota', [ServiceController::class, 'alterarNota']);
        $this->post('/getDadosUsuario', [ServiceController::class, 'getDadosUsuario']);
        $this->post('/alterarUsuario', [ServiceController::class, 'alterarUsuario']);
        $this->post('/getDadosEndereco', [ServiceController::class, 'getDadosEndereco']);
        $this->post('/salvarEndereco', [ServiceController::class, 'salvarEndereco']);
    }
}