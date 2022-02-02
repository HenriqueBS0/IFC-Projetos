<?php
    $notas = $data['notas'];
?>
<?php componente('Components/navbar'); ?>
<div class="container-fluid conteudo">
    <div class="row h-100">
        <nav class="nav h-100 overflow-auto flex-column col-lg-2 col-md-3 col-sm-4 d-none d-lg-flex d-md-flex d-sm-flex p-2">
            <div id="menu-descktop-itens-container" class="d-grid gap-2">
                <?php componente('Components/menuItems'); ?>
            </div>
        </nav>
        <div class="col container h-100 overflow-auto">
            <div class="row">
                <div class="col">
                    <div class="d-flex py-2 justify-content-center">
                        <div class="d-grid w-100">
                            <button id="botao-criar-nota" class="btn mb-3 shadow-sm text-start" type="button">
                                <i class="fas fa-plus"></i>
                                <span>Criar nota...</span>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
            <div id="notas-container" class="row"></div>
        </div>
    </div>
</div>
<?php
componente('Components/modalRotulos');
componente('Components/modalVisualizar');
componente('Components/modalCriar');
componente('Components/modalExcluir');
componente('Components/modalAlterar');
componente('Components/modalPerfil');
componente('Components/modalEndereco');
?>