<?php

namespace HenriqueBS0\Keep\Middlewares;

use HenriqueBS0\Keep\Models\UsuarioEntidade;
use HenriqueBS0\Router\Middleware;

class AutenticadoMiddleware extends Middleware
{
    public function checks(): bool
    {
        $logado = existeNaSessao('logado') && sessao('logado') === true;
        $usuarioExiste = (new UsuarioEntidade)->select()->where(['id', sessao('idUsuario') ?? 0])->exists();
        return $logado && $usuarioExiste;
    }

    public function invalidated(): void {
        redirecionar('entrar');
    }
}