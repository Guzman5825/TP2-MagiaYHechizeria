package Acciones;

import Unidades.Personaje;

public class Meditar implements Accion{
	Personaje personaje;
	
	public Meditar(Personaje personaje) {
		this.personaje = personaje;
	}

	@Override
	public void ejecutar() {
		System.out.println(personaje +": ha meditado, + 10HP , + 10EM");
		
		
	}
}
