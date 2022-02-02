<div class="modal fade" id="endereco-modal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Endereco</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <?php
                componente('Components/campoTexto', [
                    'name' => 'país',
                    'id'   => 'pais',
                    'placeholder' => 'Informe o País'
                ]);
                componente('Components/campoTexto', [
                    'name' => 'estado',
                    'placeholder' => 'Informe o Estado'
                ]);
                componente('Components/campoTexto', [
                    'name' => 'cidade',
                    'placeholder' => 'Informe a Cidade'
                ]);
                componente('Components/campoTexto', [
                    'name' => 'bairro',
                    'placeholder' => 'Informe o Bairro'
                ]);
                componente('Components/campoTexto', [
                    'name' => 'rua',
                    'placeholder' => 'Informe a Rua'
                ]);
                componente('Components/campoTexto', [
                    'name' => 'número',
                    'id'   => 'numero',
                    'type' => 'number',
                    'placeholder' => 'Informe o Número'
                ]);
                ?>
                <div class="d-grid gap-2 mx-auto">
                    <button id="button-salvar-endereco" type="button" class="btn btn-lg btn-warning">Salvar</button>
                </div>
            </div>
        </div>
    </div>
</div> -->