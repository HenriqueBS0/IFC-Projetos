<?php

namespace HenriqueBS0\Keep\Routes;

use HenriqueBS0\Keep\Controllers\AcessoController;
use HenriqueBS0\Router\RoutesGroup;

class RotasAcesso extends RoutesGroup {
    protected function setRoutes(): void
    {
        $this->get('/', [AcessoController::class, 'home']);
        $this->get('/entrar', [AcessoController::class, 'entrarView']);
        $this->post('/entrar', [AcessoController::class, 'entrar']);
        $this->get('/cadastrar', [AcessoController::class, 'cadastrarView']);
        $this->post('/cadastrar', [AcessoController::class, 'cadastrar']);
        $this->get('/sair', [AcessoController::class, 'sair']);
    }
}