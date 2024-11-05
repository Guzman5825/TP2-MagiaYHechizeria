package Efectos;

import Unidades.Personaje;

public class Protegido extends Efecto{
	Protegido(Personaje persona, int cantTurnos){
		this.personaje = persona;
		this.turnosFaltantes = cantTurnos;
	}
	@Override
	public void activar() {
		// TODO Auto-generated method stub
		
	}
}
