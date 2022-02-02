function media() {
    var nota1 = parseInt(document.getElementById("nota1").value);
    var nota2 = parseInt(document.getElementById("nota2").value);
    var nota3 = parseInt(document.getElementById("nota3").value);
    var media = (nota1 * 2 + nota2 * 3 + nota3 * 5) / 10;
    document.getElementById("media").innerHTML = "M\u00E9dia das Notas: " + media;
}
