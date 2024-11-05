package Unidades;

import java.util.ArrayList;
import java.util.List;

public class Batallon implements Combatiente {
	private List<Combatiente> combatientes;
	private int turnoActual;//puede ser que no haga falta este atributo
	
	public void agregarCombatiente(Combatiente p) {
		//implementar
	}
	
	public void eliminarCombatiente(Combatiente p) {
		//implementar
	}
/*	
	public Combatiente obtenerJugadorActual() {
		//tal vez no haga falta
	}
*/	
	public void sigTurno() {
		//tal vez no haga falta
	}
/*	
	public Personaje obtenerPersonajeConMenorVida() {
		//en discucion
	}
*/
//	Metodos de la interfaz Combatiente
	public void luchar(Combatiente enemigo) {
		//implementar
	}
	public boolean estaMuerto() {
		//implementar
		return true;
	}
	public void getInfo() {
		//A discutir
	}
}
