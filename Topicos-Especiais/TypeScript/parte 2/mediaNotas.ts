function media(): void{
  const nota1 = parseInt((<HTMLInputElement>document.getElementById("nota1")).value);
  const nota2 = parseInt((<HTMLInputElement>document.getElementById("nota2")).value);
  const nota3 = parseInt((<HTMLInputElement>document.getElementById("nota3")).value);

  const media = (nota1*2 + nota2*3 + nota3*5)/10
  document.getElementById("media").innerHTML = `Média das Notas: ${media}`
}