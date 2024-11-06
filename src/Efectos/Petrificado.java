package Efectos;

import Unidades.Personaje;

public class Petrificado extends Efecto{
	
	Petrificado(Personaje personaje){
		this.personaje = personaje;
		this.turnosFaltantes = 1;
	}
	
	Petrificado(Personaje persona, int cantTurnos){
		this.personaje = persona;
		this.turnosFaltantes = cantTurnos;
	}
	@Override
	public void activar() {
		// TODO Auto-generated method stub
		
	}
}
