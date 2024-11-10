package app;

import java.util.List;
import Unidades.*;

public class Juego {
	private Batallon batallon_1, batallon_2;
	List<Personaje> personajes_vivos_1, personajes_vivos_2;


	public Juego() { /// agrego las variable
		batallon_1 = new Batallon();
		batallon_2 = new Batallon();

	}

	public void cargarDatos() { /// aca se da todos los datos que necesitamos
		batallon_1.agregarCombatiente(new Auror("brincas"));
		batallon_1.agregarCombatiente(new Estudiante("harry"));
		batallon_1.agregarCombatiente(new Profesor("faul loger"));

		batallon_2.agregarCombatiente(new Seguidor("seguidor 1"));
		batallon_2.agregarCombatiente(new Seguidor("seguidor 2"));
		batallon_2.agregarCombatiente(new Comandante("voldemor"));
		batallon_2.agregarCombatiente(new MagoOscuro("el inombrable"));
		/////////////////// para arriba se carga los enemigos

		batallon_1.getInfo();
		batallon_2.getInfo();

		batallon_1.cargarPersonajesVivos();
		personajes_vivos_1 = batallon_1.obtenerListaPersonajesVivos();

		batallon_2.cargarPersonajesVivos();
		personajes_vivos_2 = batallon_2.obtenerListaPersonajesVivos();

	}

	public void jugar() {
		Personaje personajeActual;
		while (!this.estaTerminado()) {
			if (batallon_1.cantidadPersonajesVivos() > 0) {
				System.out.println("\n*****turno del batallon 1*****");
				personajeActual = batallon_1.obtenerSiguientePersonaje();
				personajeActual.getInfo();
				personajeActual.accionar(batallon_1, batallon_2);
			}

			batallon_1.removerPersonajesMuertos();
			batallon_2.removerPersonajesMuertos();

			if (!this.estaTerminado()) {
				if (batallon_2.cantidadPersonajesVivos() > 0) {
					System.out.println("\n*****turno del batallon 2*****");
					personajeActual = batallon_2.obtenerSiguientePersonaje();
					personajeActual.getInfo();
					personajeActual.accionar(batallon_2, batallon_1);
				}

				batallon_1.removerPersonajesMuertos();
				batallon_2.removerPersonajesMuertos();

			}

		}
		//cuando salio del while significa que termino
		if(batallon_1.batallonDerrotado()) {
			System.out.println("El batallón 2 ha ganado!");
		}
		else {
			System.out.println("El batallón 2 ha ganado!");
		}
	}

	private boolean estaTerminado() {
		return batallon_1.batallonDerrotado() || batallon_2.batallonDerrotado();
	}
}
