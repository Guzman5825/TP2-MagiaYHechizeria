package Efectos;

import Unidades.Personaje;

public class Quemado extends Efecto{
	Quemado(Personaje persona, int cantTurnos){
		this.personaje = persona;
		this.turnosFaltantes = cantTurnos;
	}
	@Override
	public void activar() {
		// TODO Auto-generated method stub
		
	}

}
