function logar() {
  const nome = document.getElementById("nome").value
  const login = document.getElementById("login")
  login.innerHTML = nome
}

function adicionar(id, valor) {
  const campoQuantidade = document.querySelector("#"+id+" .quantidade")
  const campoPrecoTotal = document.querySelector("#"+id+" .precoTotal")
  let quantidade = campoQuantidade.getAttribute("quantidade")
  quantidade++
  precoTotal = quantidade*valor
  campoQuantidade.innerHTML = quantidade
  campoPrecoTotal.innerHTML = "R$ "+precoTotal+",00"
  campoQuantidade.setAttribute("quantidade", quantidade)
}

function retirar(id, valor) {
  const campoQuantidade = document.querySelector("#"+id+" .quantidade")
  const campoPrecoTotal = document.querySelector("#"+id+" .precoTotal")
  let quantidade = campoQuantidade.getAttribute("quantidade")
  quantidade--
  quantidade = quantidade <= 0 ? 0: quantidade 
  precoTotal = quantidade*valor
  campoQuantidade.innerHTML = quantidade
  campoPrecoTotal.innerHTML = "R$ "+precoTotal+",00"
  campoQuantidade.setAttribute("quantidade", quantidade)
}

function finalizar() {
  const login = document.getElementById("login")
  login.innerHTML = "Visitante"  
  alert("Obrigado pela Preferência!!!")
}

function removerItem(id) {
  const campoApresentacao = document.querySelector("#"+id+" .apresentacao")
  const buttonRemove = document.querySelector("#"+id+" .buttonRemove")
  buttonRemove.parentNode.removeChild(buttonRemove)
  campoApresentacao.setAttribute('class', 'mensagemRemocao')
  campoApresentacao.innerHTML= "Item Removido"
}

