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
exports.Trator = void 0;
var veiculo_1 = require("./veiculo");
var Trator = /** @class */ (function (_super) {
    __extends(Trator, _super);
    function Trator(numeroDeRodas, potencia) {
        var _this = _super.call(this, 1, 0, 50, 5) || this;
        _this.numeroDeRodas = numeroDeRodas;
        _this.potencia = potencia;
        return _this;
    }
    Trator.prototype.mostraPotencia = function () {
        console.log("A pot\u00EAncia desse Trador \u00E9 de: " + this.potencia + " cv");
    };
    return Trator;
}(veiculo_1.Veiculo));
exports.Trator = Trator;
