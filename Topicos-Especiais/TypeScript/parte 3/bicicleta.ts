class Bicicleta {
  marca: string;
  modelo: string;
  tipo: string;
  tamanhoAro: number;
  tamanhoQuadro: number;
  marchas: number;
  suspensao: boolean;

  constructor(marca: string, modelo: string, tipo: string, tamanhoAro: number, 
              tamanhoQuadro: number, marchas: number, suspensao: boolean) {
    this.marca = marca;
    this.modelo = modelo;
    this.tipo = tipo; 
    this.tamanhoAro = tamanhoAro;
    this.tamanhoQuadro = tamanhoQuadro;
    this.marchas = marchas;
    this.suspensao = suspensao;
  }

  dados(){
    console.log(
      `Marca: ${this.marca}\n`+
      `Modelo: ${this.modelo}\n`+
      `Tipo: ${this.tipo}\n`+
      `Tamanho do Aro: ${this.tamanhoAro}\n`+
      `Tamanho do Quadro: ${this.tamanhoQuadro}\n`+
      `Marchas: ${this.marchas}\n`+
      `Suspensão: ${this.suspensao}\n`
    )
  }
}

const bicicleta1 = new Bicicleta('Mountain Bike', 'Caloi', 'MTB', 29, 16, 27, true)
bicicleta1.dados();

