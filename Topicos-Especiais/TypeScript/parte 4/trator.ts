import { Veiculo } from './veiculo'
import { Terrestre } from './tipoVeiculo';

class Trator extends Veiculo implements Terrestre {
  numeroDeRodas: number;
  potencia: number;
  constructor(numeroDeRodas: number, potencia: number) {
    super(1, 0, 50, 5);
    this.numeroDeRodas = numeroDeRodas;
    this.potencia = potencia;
  }
  mostraPotencia() {
    console.log(`A potência desse Trador é de: ${this.potencia} cv`);
  }
}

export { Trator };