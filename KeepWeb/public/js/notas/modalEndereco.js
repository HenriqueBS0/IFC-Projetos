import CampoTexto from "../components/forms/CampoTexto.js";
import Modal from "../components/Modal.js";
import service from "../components/Service.js";

class ModalEndereco extends Modal {
    constructor() {
        super('endereco-modal');
        this.setCampos();
        this.setEventos();
    }

    setCampos() {
        this.campoPais = new CampoTexto('pais');
        this.campoEstado = new CampoTexto('estado');
        this.campoCidade = new CampoTexto('cidade');
        this.campoBairro = new CampoTexto('bairro');
        this.campoRua = new CampoTexto('rua');
        this.campoNumero = new CampoTexto('numero');
    }

    setEventos() {
        this.campoPais.getInput().addEventListener('blur', this.campoPais.removerFeedback.bind(this.campoPais));
        this.campoEstado.getInput().addEventListener('blur', this.campoEstado.removerFeedback.bind(this.campoEstado));
        this.campoCidade.getInput().addEventListener('blur', this.campoCidade.removerFeedback.bind(this.campoCidade));
        this.campoBairro.getInput().addEventListener('blur', this.campoBairro.removerFeedback.bind(this.campoBairro));
        this.campoRua.getInput().addEventListener('blur', this.campoRua.removerFeedback.bind(this.campoRua));
        this.campoNumero.getInput().addEventListener('blur', this.campoNumero.removerFeedback.bind(this.campoNumero));

        const dropdownEndereco = document.getElementById('dropdown-endereco');
        dropdownEndereco.addEventListener('click', this.onClickDropdownEndereco.bind(this));

        const botaoSalvar = document.getElementById('button-salvar-endereco');
        botaoSalvar.addEventListener('click', this.onClickSalvar.bind(this));
    }

    async onClickDropdownEndereco() {
        const dadosEndereco = (await service.get('getDadosEndereco')).dados;
        this.campoPais.setValue(dadosEndereco.pais);
        this.campoEstado.setValue(dadosEndereco.estado);
        this.campoCidade.setValue(dadosEndereco.cidade);
        this.campoBairro.setValue(dadosEndereco.bairro);
        this.campoRua.setValue(dadosEndereco.rua);
        this.campoNumero.setValue(dadosEndereco.numero);
        this.mostrar();
    }

    async onClickSalvar() {
        let camposValidos = true;

        if(!this.campoPais.getValue()) {
            camposValidos = false;
            this.campoPais.setInvalidFeedback('Informe um país.');
        }
        if(!this.campoEstado.getValue()) {
            camposValidos = false;
            this.campoEstado.setInvalidFeedback('Informe um estado.');
        }
        if(!this.campoCidade.getValue()) {
            camposValidos = false;
            this.campoCidade.setInvalidFeedback('Informe uma cidade.');
        }
        if(!this.campoBairro.getValue()) {
            camposValidos = false;
            this.campoBairro.setInvalidFeedback('Informe um bairro.');
        }
        if(!this.campoRua.getValue()) {
            camposValidos = false;
            this.campoRua.setInvalidFeedback('Informe um rua.');
        }
        if(!this.campoNumero.getValue()) {
            camposValidos = false;
            this.campoNumero.setInvalidFeedback('Informe um número.');
        }

        if(!camposValidos) {
            return;
        }

        const dados = {
            pais : this.campoPais.getValue(),
            estado : this.campoEstado.getValue(),
            cidade : this.campoCidade.getValue(),
            bairro : this.campoBairro.getValue(),
            rua : this.campoRua.getValue(),
            numero : this.campoNumero.getValue(),
        }

        await service.get('salvarEndereco', dados);

        this.esconder();
    }


}

const modalEndereco = new ModalEndereco();
export default modalEndereco;