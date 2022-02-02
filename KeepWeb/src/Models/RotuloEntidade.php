<?php

namespace HenriqueBS0\Keep\Models;

use HenriqueBS0\Accessor\Entity;

class RotuloEntidade extends Entity {
    protected string $table = 'Rotulo';
    protected array $attributes = [
        'descricao',
        'idUsuario'
    ];

    protected string $primaryKey = 'id';

    public int $id;
    public string $descricao;
    public int $idUsuario;

    public function usuario(): UsuarioEntidade
    {
        return $this->belongsTo(UsuarioEntidade::class, 'idUsuario', 'id');
    }

    public function notas(): array
    {
        return $this->belongsToAssociation(
            NotaEntidade::class,
            'id',
            NotaHasRotuloEntidade::class,
            'idRotulo',
            'idNota'
        );
    }

    protected function beforeDelete(): void
    {
        (new NotaHasRotuloEntidade())->where(['idRotulo', $this->id])->delete();
    }
}