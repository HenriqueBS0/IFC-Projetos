function informacaoValores(valor1, valor2) {
  let informacao = ""
  if (valor1 > valor2) 
    informacao = valor1 + " é maior que " + valor2
  else if (valor1 == valor2)
    informacao = valor1 + " é igual a " + valor2
  else
    informacao = valor1 + " é menor que " + valor2
  return informacao
}

function selecionaOsCampos(idValor1, idValor2, idResultado, idInformacoes){
  const valor1 = parseInt(document.getElementById(idValor1).value)
  const valor2 = parseInt(document.getElementById(idValor2).value)
  return {
    valor1,
    valor2,
    preencheOsCampos (resultado) {
      const resultadoCampo = document.getElementById(idResultado)
      const informacaoCampo = document.getElementById(idInformacoes)
      resultadoCampo.innerHTML = resultado
      informacaoCampo.innerHTML = informacaoValores(valor1, valor2)
    }
  }
}

function soma() {
  campos = selecionaOsCampos("v1Soma", "v2Soma", "resultadoSoma", "infoSoma")
  resultado = campos.valor1 + campos.valor2
  campos.preencheOsCampos(resultado)
}

function subtracao() {
  campos = selecionaOsCampos("v1Subtracao", "v2Subtracao", "resultadoSubtracao", "infoSubtracao")
  resultado = campos.valor1 - campos.valor2
  campos.preencheOsCampos(resultado)
}

function multiplicacao() {
  campos = selecionaOsCampos("v1Multiplicacao", "v2Multiplicacao", "resultadoMultiplicacao", "infoMultiplicacao")
  resultado = campos.valor1 * campos.valor2
  campos.preencheOsCampos(resultado)
}

function divisao() {
  campos = selecionaOsCampos("v1Divisao", "v2Divisao", "resultadoDivisao", "infoDivisao")
  resultado = campos.valor1 / campos.valor2
  campos.preencheOsCampos(resultado)
}

function exponenciacao() {
  campos = selecionaOsCampos("v1Exponenciacao", "v2Exponenciacao", "resultadoExponenciacao", "infoExponenciacao")
  resultado = campos.valor1 ** campos.valor2
  campos.preencheOsCampos(resultado)
}

function radiciacao() {
  campos = selecionaOsCampos("v1Radiciacao", "v2Radiciacao", "resultadoRadiciacao", "infoRadiciacao")
  resultado =   campos.valor2 ** (1/campos.valor1)
  campos.preencheOsCampos(resultado)
}