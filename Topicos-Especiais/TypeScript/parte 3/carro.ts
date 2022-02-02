class Carro {
  modelo: string;
  marca: string;
  ano: number;
  portas: number;
  tipo_combustivel: string;
  preco: number;

  constructor(modelo: string, marca: string, ano: number,
    portas: number, tipo_combustivel: string, preco: number,) {
    this.modelo = modelo;
    this.marca = marca;
    this.ano = ano;
    this.portas = portas;
    this.tipo_combustivel = tipo_combustivel;
    this.preco = preco;
  }

  dados(){
    console.log(
      `Modelo: ${this.modelo}\n`+
      `Marca: ${this.marca}\n`+
      `Ano: ${this.ano}\n`+
      `Portas: ${this.portas}\n`+
      `Combustível: ${this.tipo_combustivel}\n`+
      `Preço: ${this.preco}\n`
    );
  }
}

const corsa = new Carro('Seda', 'Chevrolet', 2008, 4, 'Flex', 17000);
corsa.dados();