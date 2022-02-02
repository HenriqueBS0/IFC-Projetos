function geraPorcentagens() {
    var eleitores = parseInt(document.getElementById("eleitores").value);
    var votosBrancos = parseInt(document.getElementById("votosBrancos").value);
    var votosNulos = parseInt(document.getElementById("votosNulos").value);
    var votosValidos = parseInt(document.getElementById("votosValidos").value);
    var percentualVotosBrancos = (votosBrancos * 100) / eleitores;
    var percentualVotosNulos = (votosNulos * 100) / eleitores;
    var percentualVotosValidos = (votosValidos * 100) / eleitores;
    document.getElementById("percentualVotosBrancos").innerHTML = "Percentual Votos Brancos: \n                                                                 " + percentualVotosBrancos + "%<br>";
    document.getElementById("percentualVotosNulos").innerHTML = "Percentual Votos Nulos: \n                                                                 " + percentualVotosNulos + "%<br>";
    document.getElementById("percentualVotosValidos").innerHTML = "Percentual Votos Validos: \n                                                                 " + percentualVotosValidos + "%<br>";
}
