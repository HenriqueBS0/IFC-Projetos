import service from '../components/Service.js';
import filtroNotas from './filtroNotas.js';
import menu from './menu.js';
import modalEndereco from './modalEndereco.js';
import modalPerfil from './modalPerfil.js';
import modalRotulos from './modalRotulos.js';
import notasController from './notasController.js';

menu.atualizarRotulos((await service.get('getRotulos')).dados);

notasController.atualizarNotas();