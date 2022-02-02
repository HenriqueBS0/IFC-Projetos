export default class RotuloMenuItem {
    constructor(id, descricao, onClickRotuloMenu) {
        this.id = id,
        this.descricao = descricao;
        this.onClickRotuloMenu = onClickRotuloMenu;
        this.elemento = this.criarElemento();
    }

    remover() {
        this.elemento.remove();
    }

    criarElemento() {
        const button = document.createElement('button');
        button.setAttribute('class', 'btn shadow-none text-start');

        const icone = document.createElement('i');
        icone.setAttribute('class', 'fas fa-tag me-1');

        const span = document.createElement('span');
        span.insertAdjacentText('beforeend', this.descricao);

        button.insertAdjacentElement('beforeend', icone);
        button.insertAdjacentElement('beforeend', span);

        button.addEventListener('click', this.onClick.bind(this));

        return button;
    }

    ativar() {
        this.elemento.classList.add('bg-warning');
    }

    desativar() {
        this.elemento.classList.remove('bg-warning');
    }

    onClick() {
        this.onClickRotuloMenu(this);
    }
}