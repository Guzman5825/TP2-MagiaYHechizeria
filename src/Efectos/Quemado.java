package Efectos;

import Unidades.Personaje;

public class Quemado extends Efecto{
	
	public Quemado(Personaje personaje){
		this.personaje = personaje;
		this.turnosFaltantes = 5;
	}
	
	Quemado(Personaje persona, int cantTurnos){
		this.personaje = persona;
		this.turnosFaltantes = cantTurnos;
	}
	
	@Override
	public void activar() {
		int dañoBaseFuego=15;
		System.out.println(personaje+" esta quemado -"+dañoBaseFuego+"HP");
		personaje.recibirDaño(dañoBaseFuego);
	}
}
