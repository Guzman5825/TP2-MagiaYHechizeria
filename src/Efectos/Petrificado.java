package Efectos;

import Unidades.Personaje;

public class Petrificado extends Efecto{
	Petrificado(Personaje persona, int cantTurnos){
		this.personaje = persona;
		this.turnosFaltantes = cantTurnos;
	}
	@Override
	public void activar() {
		// TODO Auto-generated method stub
		
	}
}
