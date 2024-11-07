package Efectos;

import Unidades.Personaje;

public class Protegido extends Efecto{
	
	public Protegido(Personaje personaje){
		this.personaje = personaje;
		this.turnosFaltantes = 3;
	}
	
	Protegido(Personaje persona, int cantTurnos){
		this.personaje = persona;
		this.turnosFaltantes = cantTurnos;
	}
	@Override
	public void activar() {
		System.out.println(personaje+" esta protegido, reduccion de daño");
	}
}
