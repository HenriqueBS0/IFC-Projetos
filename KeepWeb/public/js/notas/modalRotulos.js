
import service from '../components/Service.js';
import Modal from '../components/Modal.js';
import RotuloModalItem from './RotuloModalItem.js';
import campoDescricaoRotulo from './campoDescricaoRotulo.js';
import menu from './menu.js';

class ModalRotulos extends Modal {
    static get MODO() {
        return {
            INSERCAO: 1,
            ALTERACAO: 2
        }
    }

    constructor() {
        super('modal-rotulos');
        this.setEventos();
        this.rotulos = [];
        this.rotulosItens = [];
        this.modo = ModalRotulos.MODO.INSERCAO;
        this.rotuloItemAlterando = null;
    }

    setEventos() {
        this.getButtonsAbrirModal().forEach(buttonElemento => buttonElemento.addEventListener('click', this.abrir.bind(this)));
        this.getButtonManutencaoRotulo().addEventListener('click', this.manutencaoRotulo.bind(this));
        this.getButtonSalvar().addEventListener('click', this.salvar.bind(this));
    }

    getButtonManutencaoRotulo() {
        return document.getElementById('button-manutencao-rotulo');
    }

    trocaIconeBotaoManutencaoAlteracao() {
        const icone = this.getButtonManutencaoRotulo().querySelector('i');
        icone.classList.remove('fa-plus');
        icone.classList.add('fa-pencil-alt');
    }

    trocaIconeBotaoManutencaoInsercao() {
        const icone = this.getButtonManutencaoRotulo().querySelector('i');
        icone.classList.remove('fa-pencil-alt');
        icone.classList.add('fa-plus');
    }

    getButtonsAbrirModal() {
        return document.querySelectorAll('.button-abrir-modal-rotulos');
    }

    getButtonSalvar() {
        return document.getElementById('button-salvar-rotulos');
    }

    async abrir() {
        this.resetarManutencao();
        this.rotulos = (await service.get('getRotulos')).dados;
        this.atualizarRotulos();
        this.mostrar();
    }

    atualizarRotulos() {
        this.rotulosItens.forEach(rotulo => rotulo.remover());
        this.rotulosItens = [];

        const container = super.getModalBody();

        this.rotulos.forEach(rotulo => {
            const rotuloItem = new RotuloModalItem(
                rotulo,
                this.onClickAlterarRotuloItem.bind(this),
                this.onClickExcluirRotuloItem.bind(this)
            );

            container.insertAdjacentElement('beforeend', rotuloItem.elemento);

            this.rotulosItens.push(rotuloItem);
        });
    }

    onClickAlterarRotuloItem(rotuloItem) {
        this.rotuloItemAlterando = rotuloItem;
        this.modo = ModalRotulos.MODO.ALTERACAO;
        campoDescricaoRotulo.setValue(rotuloItem.descricao);
        this.trocaIconeBotaoManutencaoAlteracao();

        this.rotulosItens.forEach(rotulo => {
            rotulo.desabilitar();
        });
    }

    onClickExcluirRotuloItem(rotuloItem) {
        this.rotulos = this.rotulos.filter(rotulo => rotulo.id !== rotuloItem.id);
        this.atualizarRotulos();
    }

    manutencaoRotulo() {
        if(!campoDescricaoRotulo.getValue()) {
            return;
        }

        if(this.verificaExistenciaRotulo(campoDescricaoRotulo.getValue())) {
            return campoDescricaoRotulo.setInvalidFeedback('Já existe um rotulo com essa descricao.');
        }

        if(this.modo === ModalRotulos.MODO.INSERCAO) {
            this.rotulos.push({
                id: (new Date).getTime(),
                descricao: campoDescricaoRotulo.getValue(),
                novo: true
            });
        }
        else {
            this.rotulos.forEach((rotulo, indice) => {
                if(rotulo.id === this.rotuloItemAlterando.id) {
                    this.rotulos[indice].descricao = campoDescricaoRotulo.getValue();
                }
            });
        }

        this.resetarManutencao();
        this.atualizarRotulos();
    }

    resetarManutencao() {
        this.trocaIconeBotaoManutencaoInsercao();
        campoDescricaoRotulo.setValue('');
        this.modo = ModalRotulos.MODO.INSERCAO;
        this.rotuloItemAlterando = null;
    }

    verificaExistenciaRotulo(descricao) {
        const id = ModalRotulos.MODO.ALTERACAO === this.modo ? this.rotuloItemAlterando.id : 0;
        return this.rotulos.reduce((contem, rotulo) => (rotulo.descricao === descricao && rotulo.id !== id) || contem, false);
    }

    async salvar() {
        const retorno = await service.get('salvarRotulos', {rotulos: JSON.stringify(this.rotulos)});
        menu.atualizarRotulos(retorno.dados);
        this.esconder();
    }
}

const modalRotulos = new ModalRotulos();
export default modalRotulos;