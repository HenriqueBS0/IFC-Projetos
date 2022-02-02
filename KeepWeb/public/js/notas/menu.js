import notasController from "./notasController.js";
import RotuloMenuItem from "./RotuloMenuItem.js";

class Menu {

    static instancia;

    static getInstancia() {
        if(!this.instancia) {
            this.instancia = new Menu();
        }

        return this.instancia;
    }

    constructor() {
        this.containerItensMobile = document.getElementById('menu-mobile-itens-container');
        this.rotulosMobile = [];

        this.containerItensDescktop = document.getElementById('menu-descktop-itens-container');
        this.rotulosDescktop = [];

        this.idRotuloSelecionado = null;

        this.setBotaoNotas();
    }

    setBotaoNotas() {
        this.notasItemMenuMobile = this.containerItensMobile.querySelector('.botao-notas');
        this.notasItemMenuDescktop = this.containerItensDescktop.querySelector('.botao-notas');
        this.notasItemMenuMobile.addEventListener('click', this.onClickBotaoNotas.bind(this));
        this.notasItemMenuDescktop.addEventListener('click', this.onClickBotaoNotas.bind(this));
    }

    onClickBotaoNotas() {
        this.idRotuloSelecionado = null;
        this.ativaBotaoNotas();
        this.atualizarItemAtivo();
    }

    ativaBotaoNotas() {
        this.notasItemMenuMobile.classList.add('bg-warning');
        this.notasItemMenuDescktop.classList.add('bg-warning');
        this.idRotuloSelecionado = null;
    }

    desativaBotaoNotas() {
        this.notasItemMenuMobile.classList.remove('bg-warning');
        this.notasItemMenuDescktop.classList.remove('bg-warning');
    }

    atualizarRotulos(dadosRotulos) {
        this.rotulosMobile.forEach(rotuloItem => rotuloItem.remover());
        this.rotulosDescktop.forEach(rotuloItem => rotuloItem.remover());

        this.rotulosMobile = [];
        this.rotulosDescktop = [];

        dadosRotulos.forEach(dadosRotulo => {
            const id = dadosRotulo.id;
            const descricao = dadosRotulo.descricao;
            const onClick = this.onClickRotuloItem.bind(this);

            this.rotulosMobile.push(new RotuloMenuItem(id, descricao, onClick));
            this.rotulosDescktop.push(new RotuloMenuItem(id, descricao, onClick));
        });

        this.rotulosMobile.forEach(rotuloItem => this.inserirRotuloItemMobile(rotuloItem));
        this.rotulosDescktop.forEach(rotuloItem => this.inserirRotuloItemDescktop(rotuloItem));

        this.atualizarItemAtivo();
    }

    inserirRotuloItemMobile(rotuloItem) {
        this.containerItensMobile.insertAdjacentElement('beforeend', rotuloItem.elemento)
    }

    inserirRotuloItemDescktop(rotuloItem) {
        this.containerItensDescktop.insertAdjacentElement('beforeend', rotuloItem.elemento)
    }

    onClickRotuloItem(rotuloItem) {
        this.idRotuloSelecionado = rotuloItem.id;
        this.atualizarItemAtivo();
        notasController.atualizarNotas();
    }

    atualizarItemAtivo() {
        this.desativaBotaoNotas()
        let rotuloExiste = false;

        this.rotulosMobile.forEach(rotuloItem => {
            if(rotuloItem.id === this.idRotuloSelecionado) {
                rotuloExiste = true;
                rotuloItem.ativar();
            }
            else {
                rotuloItem.desativar();
            }
        });

        this.rotulosDescktop.forEach(rotuloItem => {
            if(rotuloItem.id === this.idRotuloSelecionado) {
                rotuloExiste = true;
                rotuloItem.ativar();
            }
            else {
                rotuloItem.desativar();
            }
        });

        if(!rotuloExiste) {
            this.ativaBotaoNotas();
        }

        notasController.atualizarNotas();
    }
}


const menu = Menu.getInstancia();

export default menu;