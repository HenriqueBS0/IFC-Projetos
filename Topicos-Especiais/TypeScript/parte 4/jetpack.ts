import { Veiculo } from './veiculo'
import { Aerio } from './tipoVeiculo';

class Jetpack extends Veiculo implements Aerio {
  altura: number;
  alturaMaxima: number;
  variadorDeAltura: number;
  constructor(altura: number, alturaMaxima: number, variadorDeAltura: number) {
    super(1, 0, 20, 2);
    this.altura = altura;
    this.alturaMaxima = alturaMaxima;
    this.variadorDeAltura = variadorDeAltura;
  }
  subir() {
    this.altura = this.altura + this.variadorDeAltura <= this.alturaMaxima ?
      this.altura + this.variadorDeAltura : this.alturaMaxima;
  }
  descer() {
    this.altura = this.altura - this.variadorDeAltura >= 0 ?
      this.altura - this.variadorDeAltura : 0;
  }
  mostrarAltura() {
    console.log(`Altura Atual: ${this.altura} m`);
  }
}

export { Jetpack };