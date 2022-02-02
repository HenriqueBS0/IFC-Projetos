import Formulario from '../../components/forms/Formulario.js';
import campoEmail from '../campoEmail.js';
import campoSenha from '../campoSenha.js';
import service from '../../components/Service.js';
import alertaCredencial from '../AlertaCredencial.js';

class FormularioEntrar extends Formulario {
    constructor() {
        super('formulario-entrar');
    }

    validarCampos() {
        let camposValidos = true;

        if(!campoEmail.validar()) {
            camposValidos = false;
        }

        if(!campoSenha.validar()) {
            camposValidos = false;
        }

        return camposValidos;
    }

    async validarCredenciais() {

        const oDados = {
            email: campoEmail.getValue(),
            senha: campoSenha.getValue()
        }

        const resposta = await service.get('validarDadosEntrar', oDados);

        if(resposta.status === service.STATUS_OK) {
            return true;
        }

        const mensagens = resposta.mensagens;

        if(mensagens.email) {
            campoEmail.setInvalidFeedback(mensagens.email);
        }

        if(mensagens.senha) {
            campoSenha.setInvalidFeedback(mensagens.senha);
        }

        if(mensagens.credenciais) {
            alertaCredencial.inserirAlerta(mensagens.credenciais);
        }

        return false;
    }

    async validar() {
        const camposValidos = this.validarCampos();

        if(!camposValidos) {
            return false;
        }

        return await this.validarCredenciais();
    }
}

const formularioEntrar = new FormularioEntrar();

export default formularioEntrar;