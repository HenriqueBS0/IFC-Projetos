import CampoTexto from '../components/forms/CampoTexto.js';

class CampoDescricaoRotulo extends CampoTexto {
    constructor() {
        super('campo-descricao-rotulo');
    }

    setEventos() {
        this.getInput().addEventListener('change', this.removerFeedback.bind(this));
    }
}

const campoDescricaoRotulo = new CampoDescricaoRotulo();

export default campoDescricaoRotulo;