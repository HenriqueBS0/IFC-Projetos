export default class Campo {
    constructor(name, nome = null, id = null) {
        this.name = name;
        this.nome = nome ? nome : name;
        this.id   = id ? id : name;
        this.setEventos();
    }

    validar() {
        return true;
    }

    setEventos() {}

    getValue() {
        throw new Error(`A classe do campo ${this.nome} não implementa o método 'getValue'`);
    }

    setValue(value) {
        throw new Error(`A classe do campo ${this.nome} não implementa o método 'setValue'`);
    }

    setInvalidFeedback(feedback) {
        throw new Error(`A classe do campo ${this.nome} não implementa o método 'setInvalidFeedback'`);
    }

    setValidFeedback(feedback) {
        throw new Error(`A classe do campo ${this.nome} não implementa o método 'setValidFeedback'`);
    }

    removerFeedback() {
        throw new Error(`A classe do campo ${this.nome} não implementa o método 'removeFeedback'`);
    }
}