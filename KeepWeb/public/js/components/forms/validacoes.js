class Validacoes {
    emailInvalido(email) {
        const oRegex = /\S+@\S+\.\S+/;
        return !oRegex.test(email);
    }

    tamanhoSenhaInvalido(senha, tamanho = 6) {
        return senha.length < tamanho;
    }

    campoNaoPreenchido(valor) {
        return !valor;
    }

    possuiCaractersNumericos(string) {
        const oRegex = /\d/g;
        return oRegex.test(string);
    }

    possuiUmaUnicaPalavra(string) {
        return (string.split(' ')).length === 1;
    }
}

const validacoes = new Validacoes();

export default validacoes;