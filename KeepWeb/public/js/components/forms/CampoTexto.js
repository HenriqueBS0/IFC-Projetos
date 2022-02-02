import Campo from './Campo.js';

export default class CampoTexto extends Campo {
    constructor(name, nome = null, id = null) {
        super(name, nome, id);
    }

    getContainer() {
        return document.getElementById(`container-${this.id}`);
    }

    getLabel() {
        return this.getContainer().querySelector('label');
    }

    getInput() {
        return document.getElementById(this.id);
    }

    getContainerFeedback() {
        return document.getElementById(`feedback-${this.id}`);
    }

    getValue() {
        return this.getInput().value.trim();
    }

    setValue(value) {
        this.getInput().value = value;
    }

    removerFeedback() {
        const oInput             = this.getInput();
        const oContainerFeedback = this.getContainerFeedback();

        oInput.classList.remove('is-invalid')
        oInput.classList.remove('is-valid')
        oContainerFeedback.classList.remove('invalid-feedback');
        oContainerFeedback.classList.remove('valid-feedback');
        oContainerFeedback.innerHTML = '';
    }

    setInvalidFeedback(feedback) {
        this.removerFeedback();

        const oInput             = this.getInput();
        const oContainerFeedback = this.getContainerFeedback();

        oInput.classList.add('is-invalid')
        oContainerFeedback.classList.add('invalid-feedback');
        oContainerFeedback.innerHTML = feedback;
    }

    setValidFeedback(feedback) {
        this.removerFeedback();

        const oInput             = this.getInput();
        const oContainerFeedback = this.getContainerFeedback();

        oInput.classList.add('is-valid')
        oContainerFeedback.classList.add('valid-feedback');
        oContainerFeedback.innerHTML = feedback;
    }
}