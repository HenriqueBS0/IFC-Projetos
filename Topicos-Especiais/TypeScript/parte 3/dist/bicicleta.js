var Bicicleta = /** @class */ (function () {
    function Bicicleta(marca, modelo, tipo, tamanhoAro, tamanhoQuadro, marchas, suspensao) {
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.tamanhoAro = tamanhoAro;
        this.tamanhoQuadro = tamanhoQuadro;
        this.marchas = marchas;
        this.suspensao = suspensao;
    }
    Bicicleta.prototype.dados = function () {
        console.log("Marca: " + this.marca + "\n" +
            ("Modelo: " + this.modelo + "\n") +
            ("Tipo: " + this.tipo + "\n") +
            ("Tamanho do Aro: " + this.tamanhoAro + "\n") +
            ("Tamanho do Quadro: " + this.tamanhoQuadro + "\n") +
            ("Marchas: " + this.marchas + "\n") +
            ("Suspens\u00E3o: " + this.suspensao + "\n"));
    };
    return Bicicleta;
}());
var bicicleta1 = new Bicicleta('Mountain Bike', 'Caloi', 'MTB', 29, 16, 27, true);
bicicleta1.dados();
