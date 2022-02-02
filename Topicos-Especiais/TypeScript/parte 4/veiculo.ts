class Veiculo {
  numeroDeAcentos: number;
  velocidade: number;
  velocidadeMaxima: number;
  variadorDeVelocidade: number;

  constructor(numeroDeAcentos: number, 
              velocidade: number, 
              velocidadeMaxima: number, 
              variadorDeVelocidade: number) {
    this.numeroDeAcentos = numeroDeAcentos;
    this.velocidade = velocidade;
    this.velocidadeMaxima = velocidadeMaxima;
    this.variadorDeVelocidade = variadorDeVelocidade;
  }

  acelerar() {
    this.velocidade = this.velocidade + this.variadorDeVelocidade <= this.velocidadeMaxima ?
      this.velocidade + this.variadorDeVelocidade : this.velocidadeMaxima;
  }
  freiar() {
    this.velocidade = this.velocidade - this.variadorDeVelocidade >= 0 ?
      this.velocidade - this.variadorDeVelocidade : 0;
  }
  mostraVelocidade() {
    console.log(`Velocidade Atual: ${this.velocidade} km/h`);
  }
}

export { Veiculo };