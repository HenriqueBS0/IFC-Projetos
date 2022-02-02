<div class="modal fade" id="alterar-nota" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Alterar</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="mb-3">
                    <label for="alterar-nota-titulo" class="form-label">Titulo</label>
                    <input type="text" class="form-control" id="alterar-nota-titulo" placeholder="">
                </div>
                <div class="mb-3">
                    <label for="alterar-nota-descricao" class="form-label">Conteúdo</label>
                    <textarea class="form-control" id="alterar-nota-descricao" rows="3"></textarea>
                </div>
                <div class="mb-3">
                    <label for="alterar-nota-imagem" class="form-label">Imagens</label>
                    <input class="form-control mb-2" type="file" id="alterar-nota-imagem">
                    <div id="alterar-nota-carrosel" class="carousel slide mb-2" data-bs-ride="carousel">
                        <div class="carousel-inner"></div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#alterar-nota-carrosel" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#alterar-nota-carrosel" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                    <div class="d-grid w-100">
                        <button id="alterar-nota-botao-remover-imagem" class="btn btn-danger" type="button">
                            <i class="fas fa-trash"></i>
                            <span>Remover imagem</span>
                        </button>
                    </div>
                </div>
                <label for="">Rotulos</label>
                <div id="alterar-nota-rotulos-container">

                </div>
                <label for="alterar-notas-cor" class="form-label">Cor</label>
                <input type="color" class="form-control form-control-color" id="alterar-notas-cor" value="#563d7c" title="Choose your color">
            </div>
            <div class="modal-footer">
                <button type="button" id="alterar-nota-botao-cancelar" class="btn btn-secondary">Cancelar</button>
                <button type="button" id="alterar-nota-botao-salvar" class="btn btn-warning">Salvar</button>
            </div>
        </div>
    </div>
</div>