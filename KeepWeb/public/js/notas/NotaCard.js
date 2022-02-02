export default class NotaCard {
    constructor(nota, eventosController) {
        this.id       = nota.id;
        this.titulo   = nota.titulo;
        this.descricao = nota.descricao;
        this.cor      = nota.cor;
        this.elemento = this.criarElemento();
        this.eventosController = eventosController;
    }

    remover() {
        this.elemento.remove();
    }

    criarElemento() {
        const cardSpanTitle = document.createElement('span');
        cardSpanTitle.insertAdjacentText('beforeend', this.titulo);

        const containerButtons = this.getContainerButtons();

        const cardTitle = document.createElement('h5');
        cardTitle.setAttribute('class', 'card-title d-flex justify-content-between align-items-start');

        cardTitle.insertAdjacentElement('beforeend', cardSpanTitle);
        cardTitle.insertAdjacentElement('beforeend', containerButtons);

        const texto = document.createElement('p');
        texto.insertAdjacentText('beforeend', this.descricao);

        const cardBody = document.createElement('div');
        cardBody.setAttribute('class', 'card-body');

        cardBody.insertAdjacentElement('beforeend', cardTitle);
        cardBody.insertAdjacentElement('beforeend', texto);

        const card = document.createElement('div');
        card.setAttribute('class', 'card card-nota');
        card.setAttribute('style', `background-color:${this.cor}`);

        card.insertAdjacentElement('beforeend', cardBody);

        const container = document.createElement('div');
        container.setAttribute('class', 'col-lg-4 col-md-6 col-sm-12 mb-3');

        container.insertAdjacentElement('beforeend', card);

        return container;
    }

    getContainerButtons() {
        const cardIconeAlterar = document.createElement('i');
        cardIconeAlterar.setAttribute('class', 'fas fa-pencil-alt');

        const cardIconeVisualizar = document.createElement('i');
        cardIconeVisualizar.setAttribute('class', 'fas fa-eye');

        const cardBotaoVisualizar = document.createElement('button');
        cardBotaoVisualizar.setAttribute('class', 'btn shadow-none');
        cardBotaoVisualizar.insertAdjacentElement('beforeend', cardIconeVisualizar);

        cardBotaoVisualizar.addEventListener('click', this.onClickVisualizar.bind(this));

        const cardBotaoAlterar = document.createElement('button');
        cardBotaoAlterar.setAttribute('class', 'btn shadow-none');
        cardBotaoAlterar.insertAdjacentElement('beforeend', cardIconeAlterar);

        cardBotaoAlterar.addEventListener('click', this.onClickAlterar.bind(this));

        const cardIconeExcluir = document.createElement('i');
        cardIconeExcluir.setAttribute('class', 'fas fa-trash');

        const cardBotaoExcluir = document.createElement('button');
        cardBotaoExcluir.setAttribute('class', 'btn shadow-none');
        cardBotaoExcluir.insertAdjacentElement('beforeend', cardIconeExcluir);

        cardBotaoExcluir.addEventListener('click', this.onClickExcluir.bind(this));

        const containerButtons = document.createElement('div');
        containerButtons.setAttribute('class', 'd-flex justify-content-between align-items-center');
        containerButtons.insertAdjacentElement('beforeend', cardBotaoVisualizar);
        containerButtons.insertAdjacentElement('beforeend', cardBotaoAlterar);
        containerButtons.insertAdjacentElement('beforeend', cardBotaoExcluir);

        return containerButtons;
    }

    async onClickVisualizar(evento) {
        this.eventosController.onClickVisualizar(this);
    }

    async onClickAlterar() {
        this.eventosController.onClickAlterar(this);
    }

    async onClickExcluir() {
        this.eventosController.onClickExcluir(this);
    }
}