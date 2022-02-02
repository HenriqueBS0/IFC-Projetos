import Formulario from '../../components/forms/Formulario.js';
import campoNome from './campoNome.js';
import campoEmail from '../campoEmail.js';
import campoSenha from '../campoSenha.js';
import service from '../../components/Service.js';
import alertaCredencial from '../AlertaCredencial.js';

class FormularioCadastrar extends Formulario {
    constructor() {
        super('formulario-cadastrar');
    }

    validarCampos() {
        let camposValidos = true;

        if(!campoNome.validar()) {
            camposValidos = false;
        }

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
            nome: campoNome.getValue(),
            email: campoEmail.getValue(),
            senha: campoSenha.getValue()
        }

        const resposta = await service.get('validarDadosCadastrar', oDados);

        if(resposta.status === service.STATUS_OK) {
            return true;
        }

        const mensagens = resposta.mensagens;

        if(mensagens.nome) {
            campoNome.setInvalidFeedback(mensagens.nome);
        }

        if(mensagens.email) {
            campoEmail.setInvalidFeedback(mensagens.email);
        }

        if(mensagens.senha) {
            campoSenha.setInvalidFeedback(mensagens.senha);
        }

        if(mensagens.credenciais) {
            console.log("Cred")
            alertaCredencial.inserirAlerta(mensagens.credenciais);
        }

        return false;
    }

    async validar() {
        // const camposValidos = this.validarCampos();

        // if(!camposValidos) {
        //     return false;
        // }

        return await this.validarCredenciais();
    }
}

const formularioCadastrar = new FormularioCadastrar();

export default formularioCadastrar;