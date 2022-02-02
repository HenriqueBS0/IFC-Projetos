class Notebook {
  marca: string;
  modelo: string;
  tamanhoTela: string;
  processador: string;
  memoria: string;
  preco: number;

  constructor(marca: string, modelo: string, tamanhoTela: string,
              processador: string, memoria: string, preco: number) {
    this.marca = marca;
    this.modelo = modelo;
    this.tamanhoTela = tamanhoTela;
    this.processador = processador;
    this.memoria = memoria;
    this.preco = preco;
  }

  dadosNotebook(){
    console.log(
      `Marca: ${this.marca}\n`+
      `Modelo: ${this.modelo}\n`+
      `Tamanho de Tela: ${this.tamanhoTela}\n`+
      `Processador: ${this.processador}\n`+
      `Memória: ${this.memoria}\n`+
      `Preço: ${this.preco}\n`
    )
  }
}

const notebook1 = new Notebook('Lenovo','B490', '14 Polegadas', 'i5-3210M', '8 GB', 2000);
notebook1.dadosNotebook();
