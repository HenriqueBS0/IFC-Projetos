import service from '../components/Service.js';
import Modal from '../components/Modal.js';
import RotuloModalNotaItem from './RotuloModalNotaItem.js';
import ImagemItemCarrosel from './ImagemItemCarrosel.js';
import notasController from './notasController.js';

class ModalCriar extends Modal {
    constructor() {
        super('criar-nota');
        this.containerCarroselImgens = this.modalElemento.querySelector('.carousel-inner');
        this.containerRotulos = document.getElementById('criar-nota-rotulos-container');
        this.imagens = [];
        this.rotulos = [];
        this.nenhumaImagem = true;
        this.setEventos();
    }

    setEventos() {
        const campoImagem = document.getElementById('criar-nota-imagem');
        campoImagem.addEventListener('change', this.onChangeCampoImagem.bind(this));

        const botaoRemoverImagem = document.getElementById('criar-nota-botao-remover-imagem');
        botaoRemoverImagem.addEventListener('click', this.removerImagem.bind(this));

        const botaoCancelar = document.getElementById('criar-nota-botao-cancelar');
        botaoCancelar.addEventListener('click', this.onClickCancelar.bind(this));

        const botaoSalvar = document.getElementById('criar-nota-botao-salvar');
        botaoSalvar.addEventListener('click', this.onClickSalvar.bind(this));
    }

    async onChangeCampoImagem() {
        const campoImagem = document.getElementById('criar-nota-imagem');

        const imagem = (await service.get('criarImagem', {imagem: campoImagem.files[0]})).dados;

        this.adicionarImagem(imagem);

        this.limparCampoImagem();
    }

    adicionarImagem(imagem) {
        if(this.nenhumaImagem) {
            this.imagens[0].remover();
            this.imagens = [];
        }

        this.desativarImagens();

        const imagemItem = new ImagemItemCarrosel(imagem);

        this.imagens.push(imagemItem);

        this.containerCarroselImgens.insertAdjacentElement('beforeend', imagemItem.elemento);

        imagemItem.elemento.classList.add('active');

        this.nenhumaImagem = false;
    }

    removerImagem() {
        const imagemAtiva = this.containerCarroselImgens.querySelector('.active');
        const idImagem = imagemAtiva.getAttribute('id-imagem');

        this.imagens = this.imagens.filter(imagem => {
            if (imagem.id == idImagem) {
                imagem.remover();
                return false;
            }

            return true;
        });

        if(this.imagens.length === 0) {
            this.imagens.push(new ImagemItemCarrosel({id: 'NOT-IMAGE-CRIAR', caminho: 'not-image.png'}));
            this.containerCarroselImgens.insertAdjacentElement('beforeend', this.imagens[0].elemento);
            this.nenhumaImagem = true;
        }

        this.imagens[0].elemento.classList.add('active')
    }

    desativarImagens() {
        this.imagens.forEach(imagem => imagem.elemento.classList.remove('active'));
    }


    async onClickCancelar() {
        await service.get('destruirImagensSession');
        this.esconder();
    }

    async onClickSalvar() {
        const dados = {
            titulo: this.getTitulo(),
            descricao: this.getDescricao(),
            imagens: this.getImagens(),
            rotulos: this.getRotulos(),
            cor: this.getCor(),
        }

        await service.get('criarNota', {dados: JSON.stringify(dados)});
        await notasController.atualizarNotas();
        this.esconder();
    }

    getTitulo() {
        return document.getElementById('criar-nota-titulo').value;
    }

    getDescricao() {
        return document.getElementById('criar-nota-descricao').value;
    }

    getImagens() {
        if (this.nenhumaImagem) {
            return [];
        }

        const imagens = [];

        this.imagens.forEach(imagem => {
            imagens.push({
                id: imagem.id,
                caminho: imagem.caminho
            });
        });

        return imagens;
    }

    getRotulos() {
        const rotulos = [];
        console.log(this.rotulos);
        this.rotulos.forEach(rotulo => {
            if(rotulo.elemento.querySelector('input').checked) {
                rotulos.push(rotulo.id);
            }
        });

        return rotulos;
    }

    getCor() {
        return document.getElementById('criar-notas-cor').value;
    }

    async resetar() {
        this.limparTitulo();
        this.limparDescricao()
        this.limparCampoImagem();
        this.limparCarroselImgans();
        await this.atualizarRotulos();
    }

    limparTitulo() {
        const titulo = document.getElementById('criar-nota-titulo');
        titulo.value = '';
    }

    limparDescricao() {
        const descricao = document.getElementById('criar-nota-descricao');
        descricao.value = '';
    }

    limparCampoImagem() {
        const imagem = document.getElementById('criar-nota-imagem');
        imagem.value = '';
    }

    limparCarroselImgans() {
        this.imagens.forEach(imagem => imagem.remover());
        this.imagens = [];

        this.imagens.push(new ImagemItemCarrosel({id: 'NOT-IMAGE-CRIAR', caminho: 'not-image.png'}));

        this.containerCarroselImgens.insertAdjacentElement('beforeend', this.imagens[0].elemento);

        this.imagens[0].elemento.classList.add('active');

        this.nenhumaImagem = true;
    }

    async atualizarRotulos() {
        this.rotulos.forEach(rotulo => rotulo.remover());
        this.rotulos = [];

        const rotulos = (await service.get('getRotulos')).dados;

        rotulos.forEach(rotulo => this.rotulos.push(new RotuloModalNotaItem(rotulo, 'rotulo-criar')));

        this.rotulos.forEach(rotulo => this.containerRotulos.insertAdjacentElement('beforeend', rotulo.elemento));
    }
}

const modalCriar = new ModalCriar();

export default modalCriar;