function apresentaResultado() {
    var idade = pegaIdade();
    var mensagem = verificaMaioridade(idade) ? "Sim" : "Não";
    document.getElementById('result').innerHTML = mensagem;
}
var pegaIdade = function () {
    return parseInt(document.getElementById("idade").value);
};
var verificaMaioridade = function (idade) { return idade >= 18; };
