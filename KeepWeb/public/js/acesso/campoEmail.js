import validacoes from '../components/forms/validacoes.js';
import CampoTexto from '../components/forms/CampoTexto.js';

class CampoEmail extends CampoTexto {
    constructor() {
        super('email');
    }

    setEventos() {
        this.getInput().addEventListener('blur', this.onBlur.bind(this));
    }

    onBlur() {
        this.validarEmail();
    }

    validarEmail() {
        const email = this.getValue();
        const emailNaoInformado = validacoes.campoNaoPreenchido(email);
        const emailValido = emailNaoInformado || !validacoes.emailInvalido(email);

        if(!emailValido) {
            this.setInvalidFeedback('O campo Email não possuí um valor válido.')
            return false;
        }

        this.removerFeedback();
        return true;
    }

    validarPreenchimento() {
        const email = this.getValue();

        if(validacoes.campoNaoPreenchido(email)) {
            this.setInvalidFeedback('O campo Email é obrigatório.');
            return false;
        }

        this.removerFeedback();
        return true;
    }

    validar() {
        if(!this.validarEmail()) {
            return false;
        }

        if(!this.validarPreenchimento()) {
            return false;
        }

        return true;
    }
}

const campoEmail = new CampoEmail();

export default campoEmail;