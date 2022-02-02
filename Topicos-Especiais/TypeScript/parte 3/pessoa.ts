class Pessoa {
  nome: string;
  sobrenome: string;
  CPF: number;
  RG: number;
  dataNascimento: string;

  constructor(nome: string, sobrenome: string, CPF: number,
    RG: number, dataNascimento: string,) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.CPF = CPF;
    this.RG = RG;
    this.dataNascimento = dataNascimento;
  }

  dadosPessoa(){
    console.log(
      `Nome: ${this.nome}\n`+
      `Sobrenome: ${this.sobrenome}\n`+
      `CPF: ${this.CPF}\n`+
      `RG: ${this.RG}\n`+
      `Data de Nascimento: ${this.dataNascimento}\n`
    );
  }
}

const pessoa1 = new Pessoa('Henrique', 'Borges dos Santos', 12839458942, 7745871, '05-09-2003');
pessoa1.dadosPessoa();