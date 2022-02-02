<div class="container">
    <div class="row mt-5 mb-3 justify-content-center">
        <div class="col d-flex justify-content-center">
            <div class="container-logo">
                <img src="<?= public_path('img/keep.svg')?>" alt="">
            </div>
            <div class="p-2 align-self-center">
                <h3>Keep</h3>
            </div>
        </div>
    </div>
    <div class="row justify-content-center">
        <div id="container-alerta" class="col-lg-6 col-md-6 col-sm-12">
            <?php
                if(existeNaSessao('credenciaisInvalidas')) {
                    componente('Components/alerta', ['tipo' => 'warning', 'mensagem' => sessao('credenciaisInvalidas')]);
                }
            ?>
        </div>
    </div>
    <div class="row mb-5 justify-content-center">
        <div class="col-lg-6 col-md-6 col-sm-12">
            <div class="border border-1 rounded p-3">
                <form id="formulario-cadastrar" method="POST" action="<?= project_url('cadastrar')?>">
                    <fieldset>
                        <legend class="text-center">Cadastrar-se</legend>
                        <?php
                            componente('Components/campoTexto', [
                                'name' => 'nome',
                                'placeholder' => 'Informe seu nome'
                            ]);
                            componente('Components/campoTexto', [
                                'name' => 'email',
                                'type' => 'email',
                                'placeholder' => 'Informe seu email'
                            ]);
                            componente('Components/campoTexto', [
                                'name' => 'senha',
                                'type' => 'password',
                                'placeholder' => 'Informe sua senha'
                            ]);
                        ?>
                        <div class="d-grid gap-2 mx-auto">
                        <button id="button-submit" type="button" class="btn btn-lg btn-warning">Cadastrar</button>
                            <a href="<?= project_url('entrar') ?>" type="submit" class="btn btn-lg btn-outline-warning">Entrar</a>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>