const pegaValor = id => document.getElementById(id).value
const selecionaCampo = id => document.getElementById(id)

const calculaIMC = (idAltura, idPeso, idCampoResposta) => {
  const altura = pegaValor(idAltura)
  const peso = pegaValor(idPeso)
  const campoResposta = selecionaCampo(idCampoResposta)

  const IMC = peso / (altura ** 2)
  campoResposta.innerHTML = IMC.toFixed(5)
}
