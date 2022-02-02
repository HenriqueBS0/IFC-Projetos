var Notebook = /** @class */ (function () {
    function Notebook(marca, modelo, tamanhoTela, processador, memoria, preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.tamanhoTela = tamanhoTela;
        this.processador = processador;
        this.memoria = memoria;
        this.preco = preco;
    }
    Notebook.prototype.dadosNotebook = function () {
        console.log("Marca: " + this.marca + "\n" +
            ("Modelo: " + this.modelo + "\n") +
            ("Tamanho de Tela: " + this.tamanhoTela + "\n") +
            ("Processador: " + this.processador + "\n") +
            ("Mem\u00F3ria: " + this.memoria + "\n") +
            ("Pre\u00E7o: " + this.preco + "\n"));
    };
    return Notebook;
}());
var notebook1 = new Notebook('Lenovo', 'B490', '14 Polegadas', 'i5-3210M', '8 GB', 2000);
notebook1.dadosNotebook();
