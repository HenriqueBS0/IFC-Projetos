export default class Formulario {
    constructor(id) {
        this.id = id;
        this.setClickSubmit();
    }

    getFormulario() {
        return document.getElementById(this.id);
    }

    getButtonSubmit() {
        return this.getFormulario().querySelector('#button-submit');
    }

    setClickSubmit() {
        const oButtonSubmit = this.getButtonSubmit();
        oButtonSubmit.addEventListener('click', this.enviar.bind(this));
    }

    async validar() {
        return true;
    }

    async enviar() {
        const oFormulario = this.getFormulario();

        if(!await this.validar()) {
            return;
        }

        oFormulario.submit();
    }
}