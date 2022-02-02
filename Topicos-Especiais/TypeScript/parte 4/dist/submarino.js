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
exports.Submarino = void 0;
var veiculo_1 = require("./veiculo");
var Submarino = /** @class */ (function (_super) {
    __extends(Submarino, _super);
    function Submarino(tempoComOxigenio) {
        var _this = _super.call(this, 20, 20, 150, 2.5) || this;
        _this.tempoComOxigenio = tempoComOxigenio;
        return _this;
    }
    Submarino.prototype.mostraTempoComOxigenio = function () {
        console.log("Tempo de Oxig\u00EAnio: " + this.tempoComOxigenio + " h");
    };
    Submarino.prototype.alteraTempoComOxigenio = function (tempo) {
        this.tempoComOxigenio = tempo;
    };
    return Submarino;
}(veiculo_1.Veiculo));
exports.Submarino = Submarino;
