function maisVelho(): void {
  const idadePessoa1 = parseInt((<HTMLInputElement>document.getElementById("idadePessoa1")).value);
  const idadePessoa2 = parseInt((<HTMLInputElement>document.getElementById("idadePessoa2")).value);
  const mensagem = idadePessoa1 > idadePessoa2 ? "Pessoa 1 é mais velha" : "Pessoa 2 é mais velha";
  document.getElementById('result').innerHTML = mensagem
}