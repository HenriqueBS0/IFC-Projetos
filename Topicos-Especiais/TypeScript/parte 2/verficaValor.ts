function mostraResultado(): void{
  const valor: number = 
        parseInt((<HTMLInputElement>document.getElementById("valor")).value);
  const mensagem = verificaValor(valor) ? "Positivo" : "Negativo";
  document.getElementById("result").innerHTML = mensagem;
}
const verificaValor = (numero: number): boolean => numero >= 0;