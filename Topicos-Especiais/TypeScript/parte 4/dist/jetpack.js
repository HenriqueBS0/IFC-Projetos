"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
exports.Jetpack = void 0;
var veiculo_1 = require("./veiculo");
var Jetpack = /** @class */ (function (_super) {
    __extends(Jetpack, _super);
    function Jetpack(altura, alturaMaxima, variadorDeAltura) {
        var _this = _super.call(this, 1, 0, 20, 2) || this;
        _this.altura = altura;
        _this.alturaMaxima = alturaMaxima;
        _this.variadorDeAltura = variadorDeAltura;
        return _this;
    }
    Jetpack.prototype.subir = function () {
        this.altura = this.altura + this.variadorDeAltura <= this.alturaMaxima ?
            this.altura + this.variadorDeAltura : this.alturaMaxima;
    };
    Jetpack.prototype.descer = function () {
        this.altura = this.altura - this.variadorDeAltura >= 0 ?
            this.altura - this.variadorDeAltura : 0;
    };
    Jetpack.prototype.mostrarAltura = function () {
        console.log("Altura Atual: " + this.altura + " m");
    };
    return Jetpack;
}(veiculo_1.Veiculo));
exports.Jetpack = Jetpack;
