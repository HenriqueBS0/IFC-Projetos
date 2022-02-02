export default class RotuloModalNotaItem {
    constructor(rotulo, name) {
        this.id  = rotulo.id;
        this.descricao = rotulo.descricao;
        this.name = name;
        this.elemento = this.criarElemento();
    }

    remover() {
        this.elemento.remove();
    }

    criarElemento() {
        const container = document.createElement('div');
        container.setAttribute('class', 'form-check form-check-inline');

        const input = document.createElement('input');
        input.setAttribute('class', 'form-check-input');
        input.setAttribute('type', 'checkbox');
        input.setAttribute('id', `${this.name}-${this.id}`);

        const label = document.createElement('label');
        label.setAttribute('class', 'form-check-label');
        label.setAttribute('for', `${this.name}-${this.id}`);
        label.innerText = this.descricao;

        container.insertAdjacentElement('beforeend', input);
        container.insertAdjacentElement('beforeend', label);

        return container;
    }
}