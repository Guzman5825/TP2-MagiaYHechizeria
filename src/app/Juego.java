package app;

import enums.TiposPersonaje;
import java.util.List;
import Unidades.*;
import logger.Logger;

public class Juego {
	private Batallon batallon_1, batallon_2;
	List<Personaje> personajes_vivos_1, personajes_vivos_2;

	public Juego() {
		batallon_1 = new Batallon();
		batallon_2 = new Batallon();

	}

	public void cargarDatos() {
		batallon_1.agregarCombatiente(FactoryPersonaje.crearPersonaje("Harry Potter", TiposPersonaje.ESTUDIANTE));
		batallon_1.agregarCombatiente(FactoryPersonaje.crearPersonaje("Faul Loger", TiposPersonaje.AUROR));
		batallon_1.agregarCombatiente(FactoryPersonaje.crearPersonaje("Snape", TiposPersonaje.PROFESOR));

		Batallon batallon_3 = new Batallon();
		batallon_3.agregarCombatiente(FactoryPersonaje.crearPersonaje("GLORO!!!", TiposPersonaje.PROFESOR));
		batallon_1.agregarCombatiente(batallon_3);

		batallon_2.agregarCombatiente(FactoryPersonaje.crearPersonaje("Seguidor 1", TiposPersonaje.SEGUIDOR));
		batallon_2.agregarCombatiente(FactoryPersonaje.crearPersonaje("Seguidor 2", TiposPersonaje.SEGUIDOR));
		batallon_2.agregarCombatiente(FactoryPersonaje.crearPersonaje("Voldemort", TiposPersonaje.COMANDANTE));
		batallon_2.agregarCombatiente(FactoryPersonaje.crearPersonaje("El Inmobrable", TiposPersonaje.MAGOOSCURO));

		batallon_1.imprimirInfo();
		batallon_2.imprimirInfo();

		batallon_1.cargarPersonajesVivos();
		personajes_vivos_1 = batallon_1.obtenerListaPersonajesVivos();

		batallon_2.cargarPersonajesVivos();
		personajes_vivos_2 = batallon_2.obtenerListaPersonajesVivos();
	}

	public void cargarDatos(Batallon batallon1, Batallon batallon2) {
		batallon_1 = batallon1;
		batallon_2 = batallon2;

		batallon_1.imprimirInfo();
		batallon_2.imprimirInfo();

		batallon_1.cargarPersonajesVivos();
		personajes_vivos_1 = batallon_1.obtenerListaPersonajesVivos();

		batallon_2.cargarPersonajesVivos();
		personajes_vivos_2 = batallon_2.obtenerListaPersonajesVivos();
	}

	public void jugar() {
		Personaje personajeActual;
		while (!this.estaTerminado()) {
			if (batallon_1.cantidadPersonajesVivos() > 0) {
				Logger.agregarMensaje("\n*****turno del batallon 1*****");
				personajeActual = batallon_1.obtenerSiguientePersonaje();
				personajeActual.imprimirInfo();
				personajeActual.accionar(batallon_1, batallon_2);
			}

			batallon_1.removerPersonajesMuertos();
			batallon_2.removerPersonajesMuertos();

			if (!this.estaTerminado()) {
				if (batallon_2.cantidadPersonajesVivos() > 0) {
					Logger.agregarMensaje("\n*****turno del batallon 2*****");
					personajeActual = batallon_2.obtenerSiguientePersonaje();
					personajeActual.imprimirInfo();
					personajeActual.accionar(batallon_2, batallon_1);
				}

				batallon_1.removerPersonajesMuertos();
				batallon_2.removerPersonajesMuertos();

			}

		}

		if (batallon_1.batallonDerrotado()) {
			Logger.agregarMensaje("-----Gano el batallon 2-----");
		} else {
			Logger.agregarMensaje("-----Gano el batallon 1-----");
		}
	}

	private boolean estaTerminado() {
		return batallon_1.batallonDerrotado() || batallon_2.batallonDerrotado();
	}
}
