import menu from './menu.js';
import notasController from './notasController.js';

class FiltroNotas {
    constructor() {
        this.filtroSelecionado = 0;
        this.setComponents();
        this.setEventos();
    }

    setComponents() {
        this.camposDataInicial = document.querySelectorAll('.filtro-data-inicial');
        this.camposDataFinal = document.querySelectorAll('.filtro-data-final');
        this.camposHoraInicial = document.querySelectorAll('.filtro-hora-inicial');
        this.camposHoraFinal = document.querySelectorAll('.filtro-hora-final');
        this.camposBuscar = document.querySelectorAll('.filtro-buscar');

        this.botoesAlterarFiltro = document.querySelectorAll('.filtro-toggle');
        this.botoesLimparFiltros = document.querySelectorAll('.filtro-limpar');
    }

    setEventos() {
        this.setEventosCamposBuscar();
        this.setEventosCamposDataInicial();
        this.setEventosCamposDataFinal();
        this.setEventosCamposHoraInicial();
        this.setEventosCamposHoraFinal();
        this.setEventosBotaoLimparFiltros();
        this.setEventosBotaoAlterarFiltro();
    }

    setEventosCamposBuscar() {
        this.camposBuscar.forEach(campo => {
            campo.addEventListener('change', this.onChangeCampoBuscar.bind(this));
        });
    }

    onChangeCampoBuscar(evento) {
        this.setValor(this.camposBuscar, evento.target.value);
        notasController.atualizarNotas();
    }

    setEventosCamposDataInicial() {
        this.camposDataInicial.forEach(campo => {
            campo.addEventListener('change', this.onChangeCampoDataInicial.bind(this));
            campo.addEventListener('focus', this.onFocusCampoDataInicial.bind(this));
            campo.addEventListener('blur', this.onBlurCampoDataInicial.bind(this));
        });
    }

    onChangeCampoDataInicial(evento) {
        this.setValor(this.camposDataInicial, evento.target.value);
    }

    onFocusCampoDataInicial(evento) {
        this.camposDataInicial.forEach(campo => {
            campo.type = 'date';
        });
    }

    onBlurCampoDataInicial(evento) {
        if (evento.target.value.length > 0) {
            notasController.atualizarNotas();
            return;
        }
        this.camposDataInicial.forEach(campo => {
            campo.type = 'text';
        });
    }

    setEventosCamposDataFinal() {
        this.camposDataFinal.forEach(campo => {
            campo.addEventListener('change', this.onChangeCampoDataFinal.bind(this));
            campo.addEventListener('focus', this.onFocusCampoDataFinal.bind(this));
            campo.addEventListener('blur', this.onBlurCampoDataFinal.bind(this));
        });
    }

    onChangeCampoDataFinal(evento) {
        this.setValor(this.camposDataFinal, evento.target.value);
    }

    onFocusCampoDataFinal(evento) {
        this.camposDataFinal.forEach(campo => {
            campo.type = 'date';
        });
    }

    onBlurCampoDataFinal(evento) {
        if (evento.target.value.length > 0) {
            notasController.atualizarNotas();
            return;
        }
        this.camposDataFinal.forEach(campo => {
            campo.type = 'text';
        });
    }

    setEventosCamposHoraInicial() {
        this.camposHoraInicial.forEach(campo => {
            campo.addEventListener('change', this.onChangeCampoHoraInicial.bind(this));
            campo.addEventListener('focus', this.onFocusCampoHoraInicial.bind(this));
            campo.addEventListener('blur', this.onBlurCampoHoraInicial.bind(this));
        });
    }

    onChangeCampoHoraInicial(evento) {
        this.setValor(this.camposHoraInicial, evento.target.value);
    }

    onFocusCampoHoraInicial(evento) {
        this.camposHoraInicial.forEach(campo => {
            notasController.atualizarNotas();
            campo.type = 'time';
        });
    }

    onBlurCampoHoraInicial(evento) {
        if (evento.target.value.length > 0) {
            return;
        }
        this.camposHoraInicial.forEach(campo => {
            campo.type = 'text';
        });
    }

    setEventosCamposHoraFinal() {
        this.camposHoraFinal.forEach(campo => {
            campo.addEventListener('change', this.onChangeCampoHoraFinal.bind(this));
            campo.addEventListener('focus', this.onFocusCampoHoraFinal.bind(this));
            campo.addEventListener('blur', this.onBlurCampoHoraFinal.bind(this));
        });
    }

    onChangeCampoHoraFinal(evento) {
        this.setValor(this.camposHoraFinal, evento.target.value);
    }

    onFocusCampoHoraFinal(evento) {
        this.camposHoraFinal.forEach(campo => {
            campo.type = 'time';
        });
    }

    onBlurCampoHoraFinal(evento) {
        if (evento.target.value.length > 0) {
            notasController.atualizarNotas();
            return;
        }
        this.camposHoraFinal.forEach(campo => {
            campo.type = 'text';
        });
    }

    setEventosBotaoLimparFiltros() {
        this.botoesLimparFiltros.forEach(botao => {
            botao.addEventListener('click', this.onClickBotaoLimparFiltros.bind(this));
        });
    }

    onClickBotaoLimparFiltros() {
        this.setValor(this.camposBuscar, '');
        this.setValor(this.camposDataInicial, '');
        this.setValor(this.camposDataFinal, '');
        this.setValor(this.camposHoraInicial, '');
        this.setValor(this.camposHoraFinal, '');
        notasController.atualizarNotas();
    }

    setEventosBotaoAlterarFiltro() {
        this.botoesAlterarFiltro.forEach(botao => {
            botao.addEventListener('click', this.onClickBotaoAlterarFiltro.bind(this));
        });
    }

    onClickBotaoAlterarFiltro() {
        this.mudarFiltroSelecionado();
        this.atualizarFiltro();
        this.atualizarIconeAlterar();
    }

    atualizarFiltro() {
        this.esconderFiltros();
        this.mostrarFiltroSelecionado();
    }

    mudarFiltroSelecionado() {
        if (this.filtroSelecionado === 2) {
            this.filtroSelecionado = 0;
            return;
        }

        this.filtroSelecionado++;
    }

    mostrarFiltroSelecionado() {
        const funcoesMostrar = [
            this.mostrarFiltroBuscar.bind(this),
            this.mostrarFiltroData.bind(this),
            this.mostrarFiltroHora.bind(this)
        ];

        funcoesMostrar[this.filtroSelecionado]();
    }

    esconderFiltros() {
        this.esconderFiltroBuscar();
        this.esconderFiltroData()
        this.esconderFiltroHora();
    }

    esconderFiltroData() {
        this.esconderCamposList(this.camposDataInicial);
        this.esconderCamposList(this.camposDataFinal);
    }

    mostrarFiltroData() {
        this.mostrarCamposList(this.camposDataInicial);
        this.mostrarCamposList(this.camposDataFinal);
    }

    esconderFiltroHora() {
        this.esconderCamposList(this.camposHoraInicial);
        this.esconderCamposList(this.camposHoraFinal);
    }

    mostrarFiltroHora() {
        this.mostrarCamposList(this.camposHoraInicial);
        this.mostrarCamposList(this.camposHoraFinal);
    }

    esconderFiltroBuscar() {
        this.esconderCamposList(this.camposBuscar);
    }

    mostrarFiltroBuscar() {
        this.mostrarCamposList(this.camposBuscar);
    }

    esconderCamposList(campos) {
        campos.forEach(campo => {
            campo.classList.add('d-none');
        });
    }

    mostrarCamposList(campos) {
        campos.forEach(campo => {
            campo.classList.remove('d-none');
        });
    }

    atualizarIconeAlterar() {
        const icones = [
            'fa-calendar-week',
            'fa-clock',
            'fa-search'
        ];

        const icone = icones[this.filtroSelecionado];

        this.removerIconesAlterar();
        this.botoesAlterarFiltro.forEach(botao => {
            botao.querySelector('i').classList.add(icone);
        });
    }

    removerIconesAlterar() {
        this.botoesAlterarFiltro.forEach(botao => {
            const icone = botao.querySelector('i');
            icone.classList.remove('fa-calendar-week');
            icone.classList.remove('fa-clock');
            icone.classList.remove('fa-search');
        });
    }

    setValor(campos, valor) {
        campos.forEach(campo => {
            campo.value = valor;
        });
    }

    getFiltros() {

        const campoBuscar = this.camposBuscar[0];
        const campoDataInicial = this.camposDataInicial[0];
        const campoDataFinal = this.camposDataFinal[0];
        const campoHoraInicial = this.camposHoraInicial[0];
        const campoHoraFinal = this.camposHoraFinal[0];

        return {
            rotulo: menu.idRotuloSelecionado,
            buscar: campoBuscar.value || null,
            dataInicial: campoDataInicial.value || null,
            dataFinal: campoDataFinal.value || null,
            horaInicial: campoHoraInicial.value || null,
            horaFinal: campoHoraFinal.value || null
        }
    }
}

const filtroNotas = new FiltroNotas();
export default filtroNotas;