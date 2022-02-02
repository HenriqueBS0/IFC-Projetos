import Modal from "../components/Modal.js";
import URL from "../url.js";

class ModalVisualizar extends Modal{
    constructor() {
        super('visualizar-nota');
    }

    setarDados(dadosNota) {
        this.setarTitulo(dadosNota.titulo);
        this.setarDescricao(dadosNota.descricao);
        this.setarDatas(this.formatarData(dadosNota.dataCriacao), this.formatarData(dadosNota.dataAlteracao));
        this.setarHoras(this.formatarHora(dadosNota.dataCriacao), this.formatarHora(dadosNota.dataAlteracao));
        this.setarImagens(dadosNota.imagens);
        this.setarRotulos(dadosNota.rotulos);
    }

    formatarData(data) {
        const date = new Date(data);
        return `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}`;
    }

    formatarHora(data) {
        const date = new Date(data);
        return `${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`;
    }

    setarTitulo(titulo) {
        const elementoTitulo = document.getElementById('visualizar-nota-titulo');
        elementoTitulo.innerText = titulo;
    }

    setarDescricao(descricao) {
        const elementoTitulo = document.getElementById('visualizar-nota-descricao');
        elementoTitulo.innerText = descricao;
    }

    setarDatas(dataCriacao, dataAlteracao) {
        const campoCriacao     = document.getElementById('visualizar-nota-data-criacao');
        const campoAlteracao = document.getElementById('visualizar-nota-data-alteracao');

        campoCriacao.value = dataCriacao;
        campoAlteracao.value = dataAlteracao;
    }

    setarHoras(horaCriacao, horaAlteracao) {
        const campoCriacao     = document.getElementById('visualizar-nota-hora-criacao');
        const campoAlteracao = document.getElementById('visualizar-nota-hora-alteracao');

        campoCriacao.value = horaCriacao;
        campoAlteracao.value = horaAlteracao;
    }

    setarImagens(imagens) {
        const containerImagens = document.querySelector('#visualizar-notas-carrosel .carousel-inner');
        containerImagens.innerHTML = '';

        if(imagens.length === 0) {
            imagens.push({id: 'NOT-IMAGE-VISUALIZAR', caminho: `not-image.png`});
        }

        imagens.forEach(imagem => containerImagens.insertAdjacentElement('beforeend', this.criarCarroselItem(imagem.caminho)));

        const primeiraImagem = containerImagens.querySelector('.carousel-item');
        primeiraImagem.classList.add('active');
    }

    criarCarroselItem(link) {
        const img = document.createElement('img');
        img.setAttribute('src', `${URL}public/img/notas/${link}`);
        img.setAttribute('class', 'd-block w-100');

        const item = document.createElement('div');
        item.setAttribute('class', 'carousel-item')

        item.insertAdjacentElement('beforeend', img);

        return item;
    }

    setarRotulos(rotulos) {
        const container = document.querySelector(`#${this.id} .container-rotulos`);
        container.innerHTML = '';
        rotulos.forEach(rotulo => container.insertAdjacentElement('beforeend', this.criarItemRotulo(rotulo.descricao)));
    }

    criarItemRotulo(descricao) {
        const item = document.createElement('div');
        item.setAttribute('class', 'bg-light py-1 px-2 rounded-pill m-1');
        item.insertAdjacentText('beforeend', descricao);
        return item;
    }
}

const modalVisualizar = new ModalVisualizar();
export default modalVisualizar;