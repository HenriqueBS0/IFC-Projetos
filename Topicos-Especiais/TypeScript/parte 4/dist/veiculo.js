"use strict";
exports.__esModule = true;
exports.Veiculo = void 0;
var Veiculo = /** @class */ (function () {
    function Veiculo(numeroDeAcentos, velocidade, velocidadeMaxima, variadorDeVelocidade) {
        this.numeroDeAcentos = numeroDeAcentos;
        this.velocidade = velocidade;
        this.velocidadeMaxima = velocidadeMaxima;
        this.variadorDeVelocidade = variadorDeVelocidade;
    }
    Veiculo.prototype.acelerar = function () {
        this.velocidade = this.velocidade + this.variadorDeVelocidade <= this.velocidadeMaxima ?
            this.velocidade + this.variadorDeVelocidade : this.velocidadeMaxima;
    };
    Veiculo.prototype.freiar = function () {
        this.velocidade = this.velocidade - this.variadorDeVelocidade >= 0 ?
            this.velocidade - this.variadorDeVelocidade : 0;
    };
    Veiculo.prototype.mostraVelocidade = function () {
        console.log("Velocidade Atual: " + this.velocidade + " km/h");
    };
    return Veiculo;
}());
exports.Veiculo = Veiculo;
