interface Aerio {
  altura: number;
  alturaMaxima: number;
  variadorDeAltura: number;
  subir(): void;
  descer(): void;
  mostrarAltura(): void;
}

interface Terrestre {
  numeroDeRodas: number;
}

interface Aquatico {
  submerge: boolean;
}

export { Aerio, Terrestre, Aquatico }; 