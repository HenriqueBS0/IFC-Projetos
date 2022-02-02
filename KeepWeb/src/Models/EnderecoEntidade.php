<?php

namespace HenriqueBS0\Keep\Models;

use HenriqueBS0\Accessor\Entity;

class EnderecoEntidade extends Entity {
    protected string $table = 'Endereco';
    protected array $attributes = [
        'pais',
        'estado',
        'cidade',
        'bairro',
        'rua',
        'numero',
        'idUsuario'
    ];

    protected string $primaryKey = 'id';

    public int $id;
    public string $pais;
    public string $estado;
    public string $cidade;
    public string $bairro;
    public string $rua;
    public int $numero;
    public int $idUsuario;

    public function usuario(): ?UsuarioEntidade
    {
        return $this->belongsTo(UsuarioEntidade::class, 'idUsuario', 'id');
    }

    protected function beforeInsert(): void
    {
        $this->idUsuario = sessao('idUsuario');
    }
}