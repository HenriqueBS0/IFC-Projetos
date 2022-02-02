import { Trator } from './trator';
import { Jetpack } from './jetpack';
import { Submarino } from './submarino';

const Solis75 = new Trator(4, 75);
const Martin = new Jetpack(0, 100, 1);
const Typhoon = new Submarino(24);

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
for (let i = 0; i < 200; i++) 
  Martin.subir();
Martin.mostrarAltura();
for (let i = 0; i < 20; i++) 
  Martin.descer();
Martin.mostrarAltura();

// Submarino
Typhoon.mostraTempoComOxigenio();
Typhoon.alteraTempoComOxigenio(48);
Typhoon.mostraTempoComOxigenio();


