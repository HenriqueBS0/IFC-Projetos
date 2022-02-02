import Alerta from '../components/Alerta.js';

class AlertaCredencial extends Alerta {
    constructor() {
        super('container-alerta');
    }

    inserirAlerta(mensagem) {
        super.removerAlerta();
        super.inserirAlerta('warning', mensagem);
    }
}

const alertaCredencial = new AlertaCredencial();

export default alertaCredencial;