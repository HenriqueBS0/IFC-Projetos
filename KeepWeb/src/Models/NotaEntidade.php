<?php

namespace HenriqueBS0\Keep\Models;

use HenriqueBS0\Accessor\Entity;

class NotaEntidade extends Entity {
    protected string $table = 'Nota';
    protected array $attributes = [
        'titulo',
        'dataCriacao',
        'dataAlteracao',
        'descricao',
        'cor',
        'idUsuario'
    ];

    protected string $primaryKey = 'id';

    public int $id;
    public string $titulo;
    public string $dataCriacao;
    public string $dataAlteracao;
    public string $descricao;
    public string $cor;
    public int $idUsuario;

    public function usuario(): UsuarioEntidade
    {
        return $this->belongsTo(UsuarioEntidade::class, 'idUsuario', 'id');
    }

    public function rotulos(): array
    {
        return $this->belongsToAssociation(
            RotuloEntidade::class,
            'id',
            NotaHasRotuloEntidade::class,
            'idNota',
            'idRotulo'
        );
    }

    public function imagens(): array
    {
        return $this->hasMany(ImagemEntidade::class, 'idNota');
    }

    protected function beforeDelete(): void
    {
        (new NotaHasRotuloEntidade())->where(['idNota', $this->id])->delete();

        foreach($this->imagens() as $imagem) {
            deletarImagem($imagem->caminho);
            $imagem->delete();
        }
    }
}