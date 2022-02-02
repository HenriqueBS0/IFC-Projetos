<?php

namespace HenriqueBS0\Keep\Models;

use HenriqueBS0\Accessor\Entity;

class UsuarioEntidade extends Entity {
    protected string $table = 'Usuario';
    protected array $attributes = [
        'nome',
        'email',
        'senha',
    ];

    protected string $primaryKey = 'id';

    public int $id;
    public string $nome;
    public string $email;
    public string $senha;

    public function endereco(): ?EnderecoEntidade
    {
        return $this->hasOne(EnderecoEntidade::class, 'idUsuario');
    }

    public function notas(): array
    {
        return $this->hasMany(NotaEntidade::class, 'idUsuario');
    }

    public function rotulos(): array
    {
        return $this->hasMany(RotuloEntidade::class, 'idUsuario');
    }
}