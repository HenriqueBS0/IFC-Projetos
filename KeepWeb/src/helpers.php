<?php

function view(string $path, $js = [], $css = [], $data = []): void
{
    componente('Base/_baseTopo', ['css' => $css]);
    componente($path, $data);
    componente('Base/_baseRodape', ['js' => $js]);
}

function componente(string $path, $data = []): void
{
    include(VIEW_PATH . $path . '.php');
}

function public_path(string $path): string
{
    return PUBLIC_URL . $path;
}

function project_url(string $path): string
{
    return PROJECT_URL . $path;
}

function sessao(string $identificador, string|array|int|bool|null $dado = null)
{
    session_start();

    if (!$dado) {
        return $_SESSION[$identificador];
    }

    $_SESSION[$identificador] = $dado;
}

function existeNaSessao(string $identificador): bool
{
    session_start();

    return isset($_SESSION[$identificador]);
}

function deletaDadoSessao(string $identificador)
{
    unset($_SESSION[$identificador]);
}

function deletarImagem($imagemNome)
{
    $arquivo = PROJECT_PATH . "public/img/notas/{$imagemNome}";
    if (file_exists($arquivo)) {
        unlink($arquivo);
    }
}

function redirecionar(string $path)
{
    header("Location: " . PROJECT_URL . $path);
    exit;
}
