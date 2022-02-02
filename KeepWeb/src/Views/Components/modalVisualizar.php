<div class="modal fade" id="visualizar-nota" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Visualizar</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <h5 id="visualizar-nota-titulo">teste</h5>
                <p id="visualizar-nota-descricao"></p>
                <div class="input-group mb-3">
                    <span class="input-group-text">Data Criação/Alteração</span>
                    <input type="text" class="form-control" id="visualizar-nota-data-criacao" disabled>
                    <input type="text" class="form-control" id="visualizar-nota-data-alteracao" disabled>
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">Hora Criação/Alteração</span>
                    <input type="text" class="form-control" id="visualizar-nota-hora-criacao" disabled>
                    <input type="text" class="form-control" id="visualizar-nota-hora-alteracao" disabled>
                </div>
                <h6>Imagens</h6>
                <div id="visualizar-notas-carrosel" class="carousel slide mb-2" data-bs-ride="carousel">
                    <div class="carousel-inner"></div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#visualizar-notas-carrosel" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#visualizar-notas-carrosel" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
                <h6>Rotulos</h6>
                <div class="d-flex flex-wrap container-rotulos">
                </div>
            </div>
        </div>
    </div>
</div>