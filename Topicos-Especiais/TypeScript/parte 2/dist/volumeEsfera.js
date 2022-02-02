function apresentaVolumeEsfera() {
    var raio = getRaio();
    var volume = calculaVolumeEsfera(raio);
    document.getElementById("volume").innerHTML = "Volume da Esfera: " + volume.toFixed(3);
}
var calculaVolumeEsfera = function (raio) { return (4 * Math.PI * Math.pow(raio, 3)) / 3; };
var getRaio = function () {
    return parseInt(document.getElementById("raio").value);
};
