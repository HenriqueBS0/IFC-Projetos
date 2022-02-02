<?php

namespace HenriqueBS0\Keep\Controllers;

use HenriqueBS0\Keep\Models\UsuarioEntidade;
use stdClass;

class ValidacoesController {

    public static function possuiCaracteresNumericos(string $string): bool
    {
        $numerosEncontrados = preg_match('/\d/', $string);
        return $numerosEncontrados > 0;
    }

    public static function possuiUmaUnicaPalavra(string $string): bool
    {
        return count(explode(' ', $string)) === 1;
    }

    public static function emailValido(string $email): bool
    {
        if(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
            return false;
        }

        return true;
    }

    public static function emailUtilizado(string $email): bool
    {
        return (new UsuarioEntidade)->where(['email', "'{$email}'"])->exists();
    }

    public static function tamanhoSenhaInvalido(string $senha, int $tamanho = 6) {
        return strlen($senha) < $tamanho;
    }

    public static function validarCredenciais(string $email, string $senha): bool
    {
        $usuario = new UsuarioEntidade();

        if(!$usuario->where(['email', "'{$email}'"])->exists()) {
            return false;
        }

        $usuario = $usuario->select()->where(['email', "'{$email}'"])->first();

        if(!password_verify($senha, $usuario->senha)) {
            return false;
        }

        return true;
    }

    public static function validarCampoNome($nome): object
    {
        if(!$nome) {
            return self::getObjetoValidacao(false, 'O campo Nome é obrigatório.');
        }
        else if(self::possuiCaracteresNumericos($nome)) {
            return self::getObjetoValidacao(false, 'O campo Nome não pode ter caracteres numéricos.');
        }
        else if(self::possuiUmaUnicaPalavra($nome)) {
            return self::getObjetoValidacao(false, 'O campo Nome deve ser composto por no mínimo duas palavas.');
        }

        return self::getObjetoValidacao(true);
    }

    public static function validarCampoEmail($email): object
    {
        if(!$email) {
            return self::getObjetoValidacao(false, 'O campo Email é obrigatório.');
        }
        else if(!self::emailValido($email)) {
            return self::getObjetoValidacao(false, 'O campo Email não possuí um valor válido.');
        }

        return self::getObjetoValidacao(true);
    }

    public static function validarCampoSenha($senha): object
    {
        if(!$senha) {
            return self::getObjetoValidacao(false, 'O campo Senha é obrigatório.');
        }
        else if(ValidacoesController::tamanhoSenhaInvalido($senha)) {
            return self::getObjetoValidacao(false, 'O campo Senha deve conter no mínimo 6 caracteres.');
        }

        return self::getObjetoValidacao(true);
    }

    private static function getObjetoValidacao(bool $valido, $mensagens = ''): object
    {
        $objetoValidacao = new stdClass();
        $objetoValidacao->valido = $valido;
        $objetoValidacao->mensagens = $mensagens;

        return $objetoValidacao;
    }
}