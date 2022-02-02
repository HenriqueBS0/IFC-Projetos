<?php
  define('HTTP_HOST', $_SERVER['HTTP_HOST']);
?>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="http://<?=HTTP_HOST?>/">Jogos</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link" href="http://<?=HTTP_HOST?>/JogoDados/">Jogo de Dados</a>
        <a class="nav-link" href="http://<?=HTTP_HOST?>/ParOuImpar/">Par ou Impar</a>
        <a class="nav-link" href="http://<?=HTTP_HOST?>/PedraPapelTesoura/">Pedra, Papel ou Tesoura</a>
      </div>
    </div>
  </div>
</nav>