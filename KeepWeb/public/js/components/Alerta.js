export default class Alerta {
    constructor(idContainer) {
        this.idContainer = idContainer;
    }

    getContainer() {
        return document.getElementById(this.idContainer);
    }

    criaAlerta(tipo, mensagem) {
        const divAlerta = document.createElement('div');
        const classAlerta = `alert alert-${tipo} alert-dismissible fade show`;
        divAlerta.setAttribute('class', classAlerta);
        divAlerta.setAttribute('role', 'alert');

        const spanMensagem = document.createElement('span');
        spanMensagem.insertAdjacentText('beforeend', mensagem);

        const buttonClose = document.createElement('button');
        buttonClose.setAttribute('type', 'button');
        buttonClose.setAttribute('class', 'btn-close');
        buttonClose.setAttribute('data-bs-dismiss', 'alert');
        buttonClose.setAttribute('aria-label', 'Close');

        divAlerta.insertAdjacentElement('beforeend', spanMensagem);
        divAlerta.insertAdjacentElement('beforeend', buttonClose);

        return divAlerta;
    }

    inserirAlerta(tipo, mensagem) {
        this.getContainer().insertAdjacentElement('beforeend', this.criaAlerta(tipo, mensagem));
    }

    removerAlerta() {
        this.getContainer().innerHTML = '';
    }
}