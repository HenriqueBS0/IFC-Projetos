<?php

namespace HenriqueBS0\Keep\Models;

use HenriqueBS0\Accessor\Entity;

class ImagemEntidade extends Entity {
    protected string $table = 'Imagem';
    protected array $attributes = [
        'caminho',
        'idNota'
    ];

    protected string $primaryKey = 'id';

    public int $id;
    public string $caminho;
    public int $idNota;
}