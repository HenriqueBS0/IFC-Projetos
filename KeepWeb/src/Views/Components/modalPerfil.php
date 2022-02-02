<div class="modal fade" id="perfil-modal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Perfil</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <?php
                componente('Components/campoTexto', [
                    'name' => 'nome',
                    'id' => 'nome-perfil',
                    'placeholder' => 'Informe seu nome'
                ]);
                componente('Components/campoTexto', [
                    'name' => 'email',
                    'id' => 'email-perfil',
                    'type' => 'email',
                    'placeholder' => 'Informe seu email'
                ]);
                componente('Components/campoTexto', [
                    'name' => 'senha',
                    'id' => 'senha-perfil',
                    'type' => 'password',
                    'placeholder' => 'Informe sua senha'
                ]);
                ?>
                <div class="d-grid gap-2 mx-auto">
                    <button id="button-salvar-perfil" type="button" class="btn btn-lg btn-warning">Alterar</button>
                </div>
            </div>
        </div>
    </div>
</div> -->