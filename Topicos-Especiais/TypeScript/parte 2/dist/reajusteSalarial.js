function geraSalario() {
    var salarioAtual = parseInt(document.getElementById("salarioAtual").value);
    var percentuaReajuste = parseInt(document.getElementById("percentualReajuste").value);
    var salarioComReajuste = salarioAtual * (1 + (percentuaReajuste / 100));
    document.getElementById("salarioComReajsute").innerHTML = "Salario Com Reajuste: R$ " + salarioComReajuste;
}
