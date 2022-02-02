var Carro = /** @class */ (function () {
    function Carro(modelo, marca, ano, portas, tipo_combustivel, preco) {
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.portas = portas;
        this.tipo_combustivel = tipo_combustivel;
        this.preco = preco;
    }
    Carro.prototype.dados = function () {
        console.log("Modelo: " + this.modelo + "\n" +
            ("Marca: " + this.marca + "\n") +
            ("Ano: " + this.ano + "\n") +
            ("Portas: " + this.portas + "\n") +
            ("Combust\u00EDvel: " + this.tipo_combustivel + "\n") +
            ("Pre\u00E7o: " + this.preco + "\n"));
    };
    return Carro;
}());
var corsa = new Carro('Seda', 'Chevrolet', 2008, 4, 'Flex', 17000);
corsa.dados();
