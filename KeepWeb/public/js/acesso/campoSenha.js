import validacoes from '../components/forms/validacoes.js';
import CampoTexto from '../components/forms/CampoTexto.js';

class CampoSenha extends CampoTexto {
    constructor() {
        super('senha');
    }

    setEventos() {
        this.getInput().addEventListener('blur', this.onBlur.bind(this));
    }

    onBlur() {
        this.validarTamanhoSenha();
    }

    validarTamanhoSenha() {
        const senha = this.getValue();
        const senhaNaoInformada = validacoes.campoNaoPreenchido(senha);
        const senhaValida = senhaNaoInformada || !validacoes.tamanhoSenhaInvalido(senha);

        if(!senhaValida) {
            this.setInvalidFeedback('O campo Senha deve conter no mínimo 6 caracteres.')
            return false;
        }

        this.removerFeedback();
        return true;
    }

    validarPreenchimento() {
        const senha = this.getValue();

        if(validacoes.campoNaoPreenchido(senha)) {
            this.setInvalidFeedback('O campo Senha é obrigatório.');
            return false;
        }

        this.removerFeedback();
        return true;
    }

    validar() {
        if(!this.validarTamanhoSenha()) {
            return false;
        }

        if(!this.validarPreenchimento()) {
            return false;
        }

        return true;
    }
}

const campoSenha = new CampoSenha();

export default campoSenha;