package Efectos;

import Unidades.Personaje;

public class Petrificado extends Efecto{
	
	public Petrificado(Personaje personaje){
		this.personaje = personaje;
		this.turnosFaltantes = 1;
	}
	
	Petrificado(Personaje persona, int cantTurnos){
		this.personaje = persona;
		this.turnosFaltantes = cantTurnos;
	}
	@Override
	public void activar() {
		System.out.println(personaje+" esta petrificado, sin movimientos en el siguiente turno");
	}
}
