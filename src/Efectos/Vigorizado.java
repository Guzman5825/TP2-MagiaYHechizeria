package Efectos;

import Unidades.Personaje;

public class Vigorizado extends Efecto{

	public Vigorizado(Personaje personaje){
		this.personaje = personaje;
		this.turnosFaltantes = 10;
	}
	
	
	@Override
	public void activar() {
		System.out.println(personaje+" esta vigorizado +10HP +10MP");
		personaje.ganarMana(10);
		personaje.ganarVida(10);
	}

}
