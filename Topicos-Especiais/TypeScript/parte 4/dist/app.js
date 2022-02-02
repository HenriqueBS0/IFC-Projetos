"use strict";
exports.__esModule = true;
var trator_1 = require("./trator");
var jetpack_1 = require("./jetpack");
var submarino_1 = require("./submarino");
var Solis75 = new trator_1.Trator(4, 75);
var Martin = new jetpack_1.Jetpack(0, 100, 1);
var Typhoon = new submarino_1.Submarino(24);
// Trator
Solis75.mostraPotencia();
Solis75.mostraVelocidade();
Solis75.acelerar();
Solis75.mostraVelocidade();
Solis75.freiar();
Solis75.mostraVelocidade();
// JetPack
Martin.mostraVelocidade();
Martin.mostrarAltura();
for (var i = 0; i < 200; i++)
    Martin.subir();
Martin.mostrarAltura();
for (var i = 0; i < 20; i++)
    Martin.descer();
Martin.mostrarAltura();
// Submarino
Typhoon.mostraTempoComOxigenio();
Typhoon.alteraTempoComOxigenio(48);
Typhoon.mostraTempoComOxigenio();
