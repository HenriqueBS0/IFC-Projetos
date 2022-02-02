function maisVelho() {
    var idadePessoa1 = parseInt(document.getElementById("idadePessoa1").value);
    var idadePessoa2 = parseInt(document.getElementById("idadePessoa2").value);
    var mensagem = idadePessoa1 > idadePessoa2 ? "Pessoa 1 é mais velha" : "Pessoa 2 é mais velha";
    document.getElementById('result').innerHTML = mensagem;
}
