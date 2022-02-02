<?php
    $sufixo = $data['sufixo'];
?>

<button id="filtro-toggle-<?=$sufixo?>" type="button" class="filtro-toggle btn btn-light text-start me-lg-2 me-md-2 me-sm-2">
    <i class="fas fa-calendar-week"></i>
    <span class="d-inline d-lg-none d-md-none d-sm-none">Mudar pesquisa</span>
</button>

<input class="filtro-data-inicial form-control me-2 d-none" type="text" id="filtro-data-inicial-<?=$sufixo?>" placeholder="Data inicial">
<input class="filtro-data-final form-control me-2 d-none" type="text" id="filtro-data-final-<?=$sufixo?>"   placeholder="Data inicial">
<input class="filtro-hora-inicial form-control me-2 d-none" type="text" id="filtro-hora-inicial-<?=$sufixo?>" placeholder="Hora inicial">
<input class="filtro-hora-final form-control me-2 d-none" type="text" id="filtro-hora-final-<?=$sufixo?>"   placeholder="Hora final">
<input class="filtro-buscar form-control me-2" type="text" id="filtro-buscar-<?=$sufixo?>" placeholder="Buscar">

<button id="filtro-limpar-<?=$sufixo?>" type="button" class="filtro-limpar btn btn-light text-start me-lg-2 me-md-2 me-sm-2">
    <i class="fas fa-brush"></i>
    <span class="d-inline d-lg-none d-md-none d-sm-none">Limpar pesquisa</span>
</button>