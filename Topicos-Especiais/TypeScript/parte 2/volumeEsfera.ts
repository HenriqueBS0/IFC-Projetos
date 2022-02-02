function apresentaVolumeEsfera(){
  const raio = getRaio();
  const volume = calculaVolumeEsfera(raio);
  document.getElementById("volume").innerHTML = `Volume da Esfera: ${volume.toFixed(3)}`;
}

const calculaVolumeEsfera = (raio: number) => (4 * Math.PI * Math.pow(raio, 3))/3;
const getRaio = () => 
  parseInt((<HTMLInputElement>document.getElementById("raio")).value);