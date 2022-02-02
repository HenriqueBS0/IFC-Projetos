<?php

namespace HenriqueBS0\Keep\Controllers;

use HenriqueBS0\Keep\Models\RotuloEntidade;
use HenriqueBS0\Keep\Models\UsuarioEntidade;

class UsoController {
    public function notasView() {
        $usuario = (new UsuarioEntidade)
            ->select()
            ->where(['id', sessao('idUsuario')])
            ->first();

        $rotulos = $usuario->rotulos();
        $notas = $usuario->notas();
        view('notas', [public_path('js/notas/main.js')], [public_path('css/notas.css')], [
            'notas'   => $notas,
            'rotulos' => $rotulos
        ]);
    }
}