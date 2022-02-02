import service from "../components/Service.js";
import filtroNotas from "./filtroNotas.js";
import modalAlterar from "./modalAlterar.js";
import modalCriar from "./modalCriar.js";
import modalExclusao from "./modalExclusao.js";
import modalVisualizar from "./modalVisualizar.js";
import NotaCard from "./NotaCard.js";

class NotasController {
    constructor() {
        this.containerNotas = document.getElementById('notas-container');
        this.notas = [];
        this.setEventosBotaoCriarNota();
    }

    setEventosBotaoCriarNota() {
        const botaoCriarNota = document.getElementById('botao-criar-nota');
        botaoCriarNota.addEventListener('click', this.onClickCriarNota.bind(this));
    }

    onClickCriarNota() {
        modalCriar.resetar();
        modalCriar.mostrar();
    }

    async atualizarNotas() {
        const filtros = JSON.stringify(filtroNotas.getFiltros());
        console.log(filtros);
        const dadosNotas = (await service.get('getNotas', {filtros})).dados;
        this.carregarNotas(dadosNotas);
    }

    carregarNotas(dadosNotas) {
        this.notas.forEach(notaCard => notaCard.remover());

        this.notas = [];

        dadosNotas.forEach(dadosNota => this.notas.push(new NotaCard(dadosNota, this.getEventosCard())));

        this.notas.forEach(nota => this.containerNotas.insertAdjacentElement('beforeend', nota.elemento));
    }

    getEventosCard() {
        return {
            onClickVisualizar : this.onClickVisualizar.bind(this),
            onClickExcluir    : this.onClickExcluir.bind(this),
            onClickAlterar    : this.onClickAlterar.bind(this),
        }
    }

    async onClickVisualizar(notaCard) {
        const dadosNota = (await service.get('getDadosNota', {id: notaCard.id})).dados;
        modalVisualizar.setarDados(dadosNota);
        modalVisualizar.mostrar();
    }

    async onClickAlterar(notaCard) {
        const dadosNota = (await service.get('getDadosNota', {id: notaCard.id})).dados;
        modalAlterar.setarDados(dadosNota);
        modalAlterar.mostrar();
    }

    onClickExcluir(notaCard) {
        modalExclusao.setIdNota(notaCard.id);
        modalExclusao.mostrar();
    }
}

const notasController = new NotasController;

export default notasController;