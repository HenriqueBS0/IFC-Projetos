import Modal from "../components/Modal.js";
import service from "../components/Service.js";
import notasController from "./notasController.js";

class ModalExclusao extends Modal {
    constructor() {
        super('modal-excluir-nota');
        this.setEventos();
    }

    setIdNota(idNota) {
        this.idNota = idNota;
    }

    setEventos() {
        const excluir = this.getBotaoConfirmar();
        excluir.addEventListener('click', this.onClickExclusao.bind(this));
    }

    getBotaoConfirmar() {
        return document.getElementById('botao-confirmar-exclusao');
    }

    async onClickExclusao() {
        await service.get('excluirNota', {id: this.idNota});
        notasController.atualizarNotas();
        this.esconder();
    }
}

const modalExclusao = new ModalExclusao();
export default modalExclusao;