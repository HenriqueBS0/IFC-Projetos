export default class RotuloModalItem {
    constructor(rotulo, callbackAlterar, callbackExcluir) {
        this.id              = rotulo.id;
        this.descricao       = rotulo.descricao;
        this.desabilitado    = false;
        this.callbackAlterar = callbackAlterar;
        this.callbackExcluir = callbackExcluir;
        this.criarElemento();
    }

    desabilitar() {
        this.desabilitado = true;

        this.botaoAlterar.classList.remove('btn-warning');
        this.botaoAlterar.classList.add('btn-light');

        this.botaoExcluir.classList.remove('btn-danger');
        this.botaoExcluir.classList.add('btn-light');
    }

    remover() {
        this.elemento.remove();
    }

    alterar() {
        if(this.desabilitado) {
            return;
        }

        this.callbackAlterar(this);
    }

    excluir() {
        if(this.desabilitado) {
            return;
        }

        this.callbackExcluir(this);
    }

    criarElemento() {
        const container = document.createElement('div');
        container.setAttribute('class', 'd-flex mt-1 justify-content-between');

        container.insertAdjacentElement('beforeend', this.criarContainerDescritivo());
        container.insertAdjacentElement('beforeend', this.criarContainerAcoes());

        this.elemento = container;
    }


    criarContainerDescritivo() {
        const container = document.createElement('div');
        container.insertAdjacentElement('beforeend', this.criarBotaoIconeTag());
        container.insertAdjacentElement('beforeend', this.criarDescritivo());
        return container;
    }

    criarBotaoIconeTag() {
        const div = document.createElement('div');
        div.setAttribute('class', 'btn btn-light shadow-none me-1');

        const i = document.createElement('i');
        i.setAttribute('class', 'fas fa-tag');

        div.insertAdjacentElement('beforeend', i);

        return div;
    }

    criarDescritivo() {
        const span = document.createElement('span');
        span.insertAdjacentText('beforeend', this.descricao);
        return span;
    }

    criarContainerAcoes() {
        const container = document.createElement('div');
        container.insertAdjacentElement('beforeend', this.criarBotaoAlterar());
        container.insertAdjacentElement('beforeend', this.criarBotaoExcluir());
        return container;
    }

    criarBotaoAlterar() {
        const button = document.createElement('button');
        button.setAttribute('class', 'btn btn-warning shadow-none me-1');

        const i = document.createElement('i');
        i.setAttribute('class', 'fas fa-pencil-alt');

        button.insertAdjacentElement('beforeend', i);

        button.addEventListener('click', this.alterar.bind(this));

        this.botaoAlterar = button;
        return this.botaoAlterar;
    }

    criarBotaoExcluir() {
        const button = document.createElement('button');
        button.setAttribute('class', 'btn btn-danger shadow-none');

        const i = document.createElement('i');
        i.setAttribute('class', 'fas fa-trash');

        button.insertAdjacentElement('beforeend', i);

        button.addEventListener('click', this.excluir.bind(this));

        this.botaoExcluir = button;
        return this.botaoExcluir;
    }
}

{/* <div class="d-flex mt-1 justify-content-between">
    <div>
        <div class="btn btn-light shadow-none">
            <i class="fas fa-tag"></i>
        </div>
        <span><?= $rotulo->descricao ?></span>
    </div>
    <div>

        <button type="button" class="btn btn-danger" id-rotulo="<?= $rotulo->id ?>">
            <i class="fas fa-trash"></i>
        </button>
    </div>
</div> */}