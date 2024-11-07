package app;

import java.util.List;
import Unidades.*;

public class Juego {
	private Batallon batallon_1, batallon_2;
	List<Personaje> personajes_vivos_1, personajes_vivos_2;
	int indice_1;
	int indice_2;

	public Juego() { /// agrego las variable
		batallon_1 = new Batallon();
		batallon_2 = new Batallon();
		indice_1 = 0;
		indice_2 = 0;
	}

	public void cargarDatos() { /// aca se da todos los datos que necesitamos
		batallon_1.agregarCombatiente(new Auror("brincas"));
		batallon_1.agregarCombatiente(new Auror("einsten"));
		batallon_1.agregarCombatiente(new Profesor("profesor desk"));
		
		batallon_2.agregarCombatiente(new Seguidor("seguidor 1"));
		batallon_2.agregarCombatiente(new Seguidor("seguidor 2"));
		batallon_2.agregarCombatiente(new Seguidor("seguidor 3"));
		batallon_2.agregarCombatiente(new Seguidor("seguidor 4"));
		
		///////////////////para arriba se carga los enemigos
		
		batallon_1.getInfo();
		batallon_2.getInfo();
		
		batallon_1.cargarPersonajesVivos();
		personajes_vivos_1=batallon_1.obtenerListaPersonajesVivos();
		
		batallon_2.cargarPersonajesVivos();
		personajes_vivos_2=batallon_2.obtenerListaPersonajesVivos();
		
		
		
		/// leer batallon 2 y agregar jugadores
		/// aca se cargar a los magos
		/*
		 * batallon_1.agregarUnidad(FabricaPersonajes.
		 * crearProfesorPromedio("mago brincas"));
		 * batallon_1.agregarUnidad(FabricaPersonajes.
		 * crearProfesorPromedio("mago dormun"));
		 * 
		 * ///leer batallon 2 y agregar jugadores
		 * batallon_2.agregarUnidad(FabricaPersonajes.crearProfesorPromedio("prof 1"));
		 * batallon_2.agregarUnidad(FabricaPersonajes.crearProfesorPromedio("prof 2"));
		 * batallon_2.agregarUnidad(FabricaPersonajes.crearProfesorPromedio("prof 3"));
		 */

		/// una vez que se cargo los batallones, obtener su lista
	}

	
	public void jugar() {
		Personaje personajeActual;
		while (!this.estaTerminado()) {
			if (personajes_vivos_1.size()>0) {
				System.out.println("\n*****turno del batallon 1*****");
				personajeActual = obtenerSiguienteJugadorDeJugadores1();
				personajeActual.getInfo();
				personajeActual.accionar(batallon_1, batallon_2);
			}

			removerPersonajesMuertos();

			if (personajes_vivos_2.size()>0) {
				System.out.println("\n*****turno del batallon 2*****");
				personajeActual = obtenerSiguienteJugadorDeJugadores2();
				personajeActual.getInfo();
				personajeActual.accionar(batallon_2, batallon_1);
			}

			removerPersonajesMuertos();

		}
	}
	
	Personaje obtenerSiguienteJugadorDeJugadores1() {
		if(indice_1>=personajes_vivos_1.size())
			indice_1=indice_1%personajes_vivos_1.size();
		Personaje personajeActual = personajes_vivos_1.get(indice_1) ;
		indice_1++;
		return personajeActual;
	}
	
	Personaje obtenerSiguienteJugadorDeJugadores2() {
		if(indice_2>=personajes_vivos_2.size())
			indice_2=indice_2%personajes_vivos_2.size();
		Personaje personajeActual = personajes_vivos_2.get(indice_2) ;
		indice_2++;
		return personajeActual;
	}

	private void removerPersonajesMuertos() {
		if (personajes_vivos_1.size() > 0) {
			int i = 0;
			while (i < personajes_vivos_1.size()) {
				Personaje p = personajes_vivos_1.get(i);
				if (p.estaMuerto()) {
					System.out.println(p+" se fue de sabatico!!!!!");
					personajes_vivos_1.remove(i);
					i--;
				}
				i++;
			}
		}

		if (personajes_vivos_2.size() > 0) {
			int i = 0;
			while (i < personajes_vivos_2.size()) {
				Personaje p = personajes_vivos_2.get(i);
				if (p.estaMuerto()) {
					System.out.println(p+" ah sido incapacitado");
					personajes_vivos_2.remove(i);
					i--;
				}
				i++;
			}
		}
	}

	private boolean estaTerminado() {
		return personajes_vivos_1.size()<=0 || personajes_vivos_2.size()<=0;
	}
}
