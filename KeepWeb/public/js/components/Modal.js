import '../../bootstrap/js/bootstrap.min.js';

export default class Modal {
    constructor(idModal) {
        this.id = idModal;
        this.modalElemento = document.getElementById(this.id)
        this.modalBootstrap = new bootstrap.Modal(this.modalElemento);
    }

    getModalBody() {
        return this.modalElemento.querySelector('.modal-body');
    }

    mostrar() {
        this.modalBootstrap.show();
    }

    esconder() {
        this.modalBootstrap.hide();
    }
}