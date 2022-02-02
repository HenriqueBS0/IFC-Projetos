<?php
$arma = isset($_POST['arma']) ? $_POST['arma'] : '';

$armas = [
    1 => 'pedra',
    2 => 'papel',
    3 => 'tesoura'
];

$armaComputador = $armas[rand(1, 3)];

$ganhouComPedra   = $arma === 'pedra'   && $armaComputador === 'tesoura';
$ganhouComPapel   = $arma === 'papel'   && $armaComputador === 'pedra';
$ganhouComTesoura = $arma === 'tesoura' && $armaComputador === 'papel';

if ($ganhouComPapel || $ganhouComPedra || $ganhouComTesoura) {
    $resultado = 'Jogador Ganhou!';
} else if ($arma === $armaComputador) {
    $resultado = 'Empate!';
} else {
    $resultado = 'Computador Ganhou!';
}

$mostrar = $arma !== '';
?>

<!DOCTYPE html>
<html lang="en">
<?php
$tituloPagina = "Pedra, Papel ou Tesoura";
include_once('../head.php');
?>

<body>
    <?php include_once('../menu.php'); ?>
    <div class="container">
        <div class="row">
            <div class="col d-flex justify-content-center">
                <h1><?= $tituloPagina ?></h1>
            </div>
        </div>
        <div class="row">
            <div class="col d-flex justify-content-center">
                <div class="card w-50">
                    <div class="card-body">
                        <form method="POST">
                            <legend>Arma</legend>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="arma" id="arma1" value="pedra" <?= $arma == 'pedra' ? 'checked' : ''; ?>>
                                <label class="form-check-label" for="arma1">
                                    Pedra
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="arma" id="arma2" value="papel" <?= $arma == 'papel' ? 'checked' : ''; ?>>
                                <label class="form-check-label" for="arma2">
                                    Papel
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="arma" id="arma3" value="tesoura" <?= $arma == 'tesoura' ? 'checked' : ''; ?>>
                                <label class="form-check-label" for="arma3">
                                    Tesoura
                                </label>
                            </div>
                            <input class="btn btn-primary" type="submit" value="Jogar">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <?php
        if ($mostrar) {
        ?>
            <div class="row">
                <div class="col d-flex justify-content-center">
                    <h2><?= $resultado ?></h2>
                </div>
            </div>
            <div class="row">
                <div class="col d-flex flex-column align-items-center">
                    <h3>Arma Jogador: <?= $arma ?></h3>
                    <div class="img-container">
                        <img src="img/<?= $arma ?>.png" class="img-fluid">
                    </div>
                </div>
                <div class="col d-flex flex-column align-items-center">
                    <h3>Arma Computador: <?= $armaComputador ?></h3>
                    <div class="img-container">
                        <img src="img/<?= $armaComputador ?>.png" class="img-fluid">
                    </div>
                </div>
            </div>
        <?php
        } ?>
    </div>

</body>

</html>