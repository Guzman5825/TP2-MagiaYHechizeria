package Efectos;

import Unidades.Personaje;

public class Envenenado extends Efecto{
	
	public Envenenado(Personaje personaje){
		this.personaje = personaje;
		this.turnosFaltantes = 5;
	}

	Envenenado(Personaje personaje, int cantTurnos){
		this.personaje = personaje;
		this.turnosFaltantes = cantTurnos;
	}
	
	@Override
	public void activar() {
		int dañoBaseVeneno=10;
		System.out.println("veneno activado,"+personaje+",-"+dañoBaseVeneno);
		personaje.recibirDaño(dañoBaseVeneno);
	}
}
