import URL from '../url.js';

class Service {
    static SERVICE_URL = `${URL}service/`;

    constructor() {
        this.STATUS_OK = 'ok';
        this.STATUS_ERRO = 'erro';
    }

    async get(sUrl, oDados = {}) {
        const resposta = await fetch(`${Service.SERVICE_URL}${sUrl}`, {
            method: 'POST',
            body: this.objectToFormData(oDados),
        });
        return resposta.json();
    }

    objectToFormData(oDados) {
        const formData = new FormData();

        for (const name in oDados) {
            formData.append(name, oDados[name]);
        }

        return formData;
    }
}

const service = new Service();

export default service;