<?php
    $tipo = $data['tipo'];
    $mensagem = $data['mensagem'];
?>

<div class="alert alert-<?= $tipo ?> alert-dismissible fade show" role="alert">
  <span><?= $mensagem ?></span>
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>