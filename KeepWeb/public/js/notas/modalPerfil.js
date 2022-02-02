import CampoTexto from "../components/forms/CampoTexto.js";
import Modal from "../components/Modal.js";
import service from "../components/Service.js";

class ModalPerfil extends Modal {
    constructor() {
        super('perfil-modal');
        this.setCampos();
        this.setEventos();
    }

    setCampos() {
        this.campoNome = new CampoTexto('nome-perfil');
        this.campoEmail = new CampoTexto('email-perfil');
        this.campoSenha = new CampoTexto('senha-perfil');

    }

    setEventos() {
        this.campoNome.getInput().addEventListener('blur', this.campoNome.removerFeedback.bind(this.campoNome));
        this.campoEmail.getInput().addEventListener('blur', this.campoEmail.removerFeedback.bind(this.campoEmail));
        this.campoSenha.getInput().addEventListener('blur', this.campoSenha.removerFeedback.bind(this.campoSenha));

        const dropdownPerfil = document.getElementById('dropdown-perfil');
        dropdownPerfil.addEventListener('click', this.onClickDropdownPerfil.bind(this));

        const botaoSalvar = document.getElementById('button-salvar-perfil');
        botaoSalvar.addEventListener('click', this.onClickSalvar.bind(this));
    }

    async onClickDropdownPerfil() {
        const dadosUsuario = (await service.get('getDadosUsuario')).dados;
        this.campoNome.setValue(dadosUsuario.nome);
        this.campoEmail.setValue(dadosUsuario.email);
        this.campoSenha.setValue('');
        this.mostrar();
    }

    async onClickSalvar() {
        let camposValidos = true;

        if(!this.campoNome.getValue()) {
            camposValidos = false;
            this.campoNome.setInvalidFeedback('Informe um nome.');
        }
        if(!this.campoEmail.getValue()) {
            camposValidos = false;
            this.campoEmail.setInvalidFeedback('Informe um email.');
        }
        if(this.campoSenha.getValue().length > 0 && this.campoSenha.getValue().length <= 5) {
            camposValidos = false;
            this.campoSenha.setInvalidFeedback('A senha deve conter no mínimo 6 caracters');
        }

        if(!camposValidos) {
            return;
        }

        const dados = {
            nome: this.campoNome.getValue(),
            email: this.campoEmail.getValue(),
            senha: this.campoSenha.getValue(),
        }

        await service.get('alterarUsuario', dados);

        this.esconder();
    }


}

const modalPerfil = new ModalPerfil();
export default modalPerfil;