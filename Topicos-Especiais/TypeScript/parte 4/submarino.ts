import { Veiculo } from './veiculo'
import { Aquatico } from './tipoVeiculo';

class Submarino extends Veiculo implements Aquatico {
  submerge: true;
  tempoComOxigenio: number
  constructor(tempoComOxigenio: number) {
    super(20, 20, 150, 2.5);
    this.tempoComOxigenio = tempoComOxigenio;
  }
  mostraTempoComOxigenio(){
    console.log(`Tempo de Oxigênio: ${this.tempoComOxigenio} h`);
  }
  alteraTempoComOxigenio(tempo: number){
    this.tempoComOxigenio = tempo;
  }
}

export { Submarino };