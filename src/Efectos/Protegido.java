package Efectos;

import Unidades.Personaje;

public class Protegido extends Efecto{
	
	Protegido(Personaje personaje){
		this.personaje = personaje;
		this.turnosFaltantes = 3;
	}
	
	Protegido(Personaje persona, int cantTurnos){
		this.personaje = persona;
		this.turnosFaltantes = cantTurnos;
	}
	@Override
	public void activar() {
		// TODO Auto-generated method stub
		
	}
}
