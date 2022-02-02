function geraSalario(): void{
  const salarioAtual = parseInt((<HTMLInputElement>document.getElementById("salarioAtual")).value);
  const percentuaReajuste = parseInt((<HTMLInputElement>document.getElementById("percentualReajuste")).value);

  const salarioComReajuste = salarioAtual*(1+(percentuaReajuste/100));

  document.getElementById("salarioComReajsute").innerHTML = `Salario Com Reajuste: R$ ${salarioComReajuste}`;
}