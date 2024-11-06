package Efectos;

import Unidades.Personaje;

public class Potenciado extends Efecto{	
	Potenciado(Personaje personaje){
		this.personaje = personaje;
		this.turnosFaltantes = 2;
	}

	Potenciado(Personaje persona, int cantTurnos){
		this.personaje = persona;
		this.turnosFaltantes = cantTurnos;
	}
	@Override
	public void activar() {
		// TODO Auto-generated method stub
		
	}
}
