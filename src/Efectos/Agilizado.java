package Efectos;

import Unidades.Personaje;

public class Agilizado extends Efecto{

	public Agilizado(Personaje personaje){
		this.personaje = personaje;
		this.turnosFaltantes = 1;
	}
	
	@Override
	public void activar() {
		System.out.println(personaje+" esta Agilizado al 100%, si tiene turnos");
	}

}
