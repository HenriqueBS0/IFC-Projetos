function mostraResultado() {
    var valor = parseInt(document.getElementById("valor").value);
    var mensagem = verificaValor(valor) ? "Positivo" : "Negativo";
    document.getElementById("result").innerHTML = mensagem;
}
var verificaValor = function (numero) { return numero >= 0; };
