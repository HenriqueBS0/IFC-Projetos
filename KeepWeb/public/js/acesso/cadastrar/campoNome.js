import CampoTexto from "../../components/forms/CampoTexto.js";
import validacoes from "../../components/forms/validacoes.js";

class CampoNome extends CampoTexto {
    constructor() {
        super('nome');
    }

    setEventos() {
        this.getInput().addEventListener('blur', this.onBlur.bind(this));
    }

    onBlur() {
        this.validarNome();
    }

    validarNome() {
        this.removerFeedback();
        const nome = this.getValue();

        if(validacoes.campoNaoPreenchido(nome)) {
            return true;
        }

        if(validacoes.possuiCaractersNumericos(nome)) {
            this.setInvalidFeedback('O campo Nome não pode ter caracteres numéricos.');
            return false;
        }

        if(validacoes.possuiUmaUnicaPalavra(nome)) {
            this.setInvalidFeedback('O campo Nome deve ser composto por no mínimo duas palavas.');
            return false;
        }

        return true;
    }

    validarPreenchimento() {
        const nome = this.getValue();

        if(validacoes.campoNaoPreenchido(nome)) {
            this.setInvalidFeedback('O campo Nome é obrigatório.');
            return false;
        }

        this.removerFeedback();
        return true;
    }

    validar() {
        if(!this.validarNome()) {
            return false;
        }

        if(!this.validarPreenchimento()) {
            return false;
        }

        return true;
    }
}

const campoNome = new CampoNome();

export default campoNome;