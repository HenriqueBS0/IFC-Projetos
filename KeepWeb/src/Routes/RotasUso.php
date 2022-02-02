<?php

namespace HenriqueBS0\Keep\Routes;

use HenriqueBS0\Keep\Controllers\UsoController;
use HenriqueBS0\Keep\Middlewares\AutenticadoMiddleware;
use HenriqueBS0\Router\RoutesGroup;
class RotasUso extends RoutesGroup
{
    protected function setRoutes(): void
    {
        $this->addMiddleware(AutenticadoMiddleware::class);

        $this->group('/notas');

        $this->get('/', [UsoController::class, 'notasView']);
    }
}