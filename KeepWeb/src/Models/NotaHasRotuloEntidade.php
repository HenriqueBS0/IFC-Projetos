<?php

namespace HenriqueBS0\Keep\Models;

use HenriqueBS0\Accessor\Entity;

class NotaHasRotuloEntidade extends Entity {
    protected string $table = 'Nota_has_Rotulo';
    protected array $attributes = [
        'idNota',
        'idRotulo'
    ];

    public int $idNota;
    public int $idRotulo;
}