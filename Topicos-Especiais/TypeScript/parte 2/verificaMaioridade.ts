function apresentaResultado() {
  const idade = pegaIdade();
  const mensagem = verificaMaioridade(idade) ? "Sim" : "Não";
  document.getElementById('result').innerHTML = mensagem;
}
const pegaIdade = () => 
  parseInt((<HTMLInputElement>document.getElementById("idade")).value);
const verificaMaioridade = (idade: number) => idade >= 18;
