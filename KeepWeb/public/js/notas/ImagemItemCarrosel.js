import URL from "../url.js";

export default class ImagemItemCarrosel {
    constructor(imagem) {
        this.id = imagem.id,
        this.caminho = imagem.caminho;
        this.elemento = this.criarElementoNota();
    }

    remover() {
        this.elemento.remove();
    }

    criarElementoNota() {
        const img = document.createElement('img');
        img.setAttribute('src', `${URL}public/img/notas/${this.caminho}`);
        img.setAttribute('class', 'd-block w-100');

        const item = document.createElement('div');
        item.setAttribute('class', 'carousel-item')
        item.setAttribute('id-imagem', this.id);

        item.insertAdjacentElement('beforeend', img);

        return item;
    }
}