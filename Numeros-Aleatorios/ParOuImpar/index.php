<?php
$numero = isset($_POST['numero']) ? $_POST['numero'] : 0;
$parImpar = isset($_POST['parImpar']) ? $_POST['parImpar'] : '';

$mostrar = $numero !== 0 && $parImpar !== '';

$numeroComputador = rand(1, 5);
$soma = $numero + $numeroComputador;

$jogadorGanhaComPar = $soma % 2 === 0 && $parImpar === 'par';
$jogadorGanhaComImpar = $soma % 2 !== 0 && $parImpar === 'impar';
$jogadorGanhou = $jogadorGanhaComPar || $jogadorGanhaComImpar;

$resultado = $jogadorGanhou ? "Jogador Ganhou!" : "Computador Ganhou!";

?>


<!DOCTYPE html>
<html lang="en">
<?php
$tituloPagina = "Par ou Impar";
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
                            <legend>Informações</legend>
                            <select class="form-select" name="numero">
                                <?php
                                for ($i = 1; $i <= 5; $i++) {
                                    if ($i == $numero) {
                                        $option = "<option value='{$i}' selected>{$i}</option>";
                                    } else {
                                        $option = "<option value='{$i}'>{$i}</option>";
                                    }
                                    echo $option;
                                }
                                ?>
                            </select>

                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="parImpar" id="parImpar1" value="par" <?= $parImpar == 'par' ? 'checked' : ''; ?>>
                                <label class="form-check-label" for="parImpar1">
                                    Par
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="parImpar" id="parImpar2" value="impar" <?= $parImpar != 'par' ? 'checked' : ''; ?>>
                                <label class="form-check-label" for="parImpar2">
                                    Impar
                                </label>
                            </div>
                            <div class="d-grid">
                                <input type="submit" class="btn btn-primary" value="Jogar">
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <?php
    if ($mostrar) {
    ?>
        <div class="container">
            <div class="container">
                <div class="row">
                    <div class="col d-flex justify-content-center">
                        <h2><?= $resultado ?></h2>
                    </div>
                </div>
            </div>
            <div class="row">
                    <div class="col-12 d-flex flex-column align-items-start">
                        <h3>Número do Jogador: <?= $numero ?></h2>
                    </div>

                    <div class="col-12 d-flex flex-column align-items-start">
                        <h3>Número do Computador: <?= $numeroComputador ?></h3>
                    </div>

                    <div class="col-12 d-flex flex-column align-items-start">
                        <h3>Soma: <?= $soma ?></h3>
                    </div>
            </div>
        </div>
    <?php
    }
    ?>
</body>

</html>