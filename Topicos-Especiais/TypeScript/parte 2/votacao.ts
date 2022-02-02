function geraPorcentagens() : void {
  const eleitores = parseInt((<HTMLInputElement>document.getElementById("eleitores")).value);
  const votosBrancos = parseInt((<HTMLInputElement>document.getElementById("votosBrancos")).value);
  const votosNulos = parseInt((<HTMLInputElement>document.getElementById("votosNulos")).value);
  const votosValidos = parseInt((<HTMLInputElement>document.getElementById("votosValidos")).value);

  const percentualVotosBrancos : number = (votosBrancos*100)/eleitores;
  const percentualVotosNulos : number = (votosNulos*100)/eleitores;
  const percentualVotosValidos : number = (votosValidos*100)/eleitores;

  document.getElementById("percentualVotosBrancos").innerHTML = `Percentual Votos Brancos: 
                                                                 ${percentualVotosBrancos}%<br>`
  document.getElementById("percentualVotosNulos").innerHTML = `Percentual Votos Nulos: 
                                                                 ${percentualVotosNulos}%<br>`                                                              
  document.getElementById("percentualVotosValidos").innerHTML = `Percentual Votos Validos: 
                                                                 ${percentualVotosValidos}%<br>`                                                                
}

