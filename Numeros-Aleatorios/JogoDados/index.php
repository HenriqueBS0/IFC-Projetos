<?php

$dado1 = geraDado();
$dado2 = geraDado();

$dado3 = geraDado();
$dado4 = geraDado();

$pontuacaoJogador    = $dado1->valor + $dado2->valor;
$pontuacaoComputador = $dado3->valor + $dado4->valor;

$pontuacaoVencedor
    = $pontuacaoJogador > $pontuacaoComputador
    ? $pontuacaoJogador
    : $pontuacaoComputador;

if ($pontuacaoJogador > $pontuacaoComputador) {
    $resultado = "O jogador ganhou!";
} else if ($pontuacaoJogador < $pontuacaoComputador) {
    $resultado = "O computador ganhou!";
} else {
    $resultado = "Empate!";
}

function geraDado()
{
    $imgDados = [
        1 => 'um',
        2 => 'dois',
        3 => 'tres',
        4 => 'quatro',
        5 => 'cinco',
        6 => 'seis',
    ];

    $valorDado = rand(1, 6);

    return (object) [
        'valor' => $valorDado,
        'img'   => $imgDados[$valorDado]
    ];
}
?>


<!DOCTYPE html>
<html lang="en">
<?php
$tituloPagina = "Jogo de Dados";
include_once('../head.php');
?>
<style>
    .img-container {
        width: 100px;
        height: 100px;
        margin: 16px;
    }
</style>

<body>
    <?php include_once('../menu.php'); ?>
    <div class="container">
        <div class="row">
            <div class="col d-flex justify-content-center">
                <h1><?= $tituloPagina ?></h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col d-flex justify-content-center">
            <h2><?= $resultado ?></h2>
        </div>
    </div>
    <div class="row">
        <div class="col d-flex flex-column align-items-center">
            <h3>Potuação Jogador: <?= $pontuacaoJogador ?></h3>
            <div class="img-container">
                <img src="img/<?= $dado1->img ?>.png" class="img-fluid">
            </div>
            <div class="img-container">
                <img src="img/<?= $dado2->img ?>.png" class="img-fluid">
            </div>
        </div>
        <div class="col d-flex flex-column align-items-center">
            <h3>Potuação Computador: <?= $pontuacaoComputador ?></h3>
            <div class="img-container">
                <img src="img/<?= $dado3->img ?>.png" class="img-fluid">
            </div>
            <div class="img-container">
                <img src="img/<?= $dado4->img ?>.png" class="img-fluid">
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col d-flex justify-content-center">
            <form method="post">
                <input class="btn btn-primary btn-lg" type="submit" value="Jogar">
            </form>
        </div>
    </div>
</body>

</html>