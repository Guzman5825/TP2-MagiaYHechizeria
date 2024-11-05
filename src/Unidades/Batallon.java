package Unidades;

import java.util.ArrayList;
import java.util.List;

public class Batallon implements Combatiente {
	private List<Combatiente> combatientes;
	private List<Personaje> personajesVivos;
	
	Batallon(){
		this.combatientes = new ArrayList<Combatiente>();
		this.personajesVivos = new ArrayList<Personaje>();
	}
	Batallon(List<Combatiente> combatientes){
		this.combatientes = combatientes;
	}
	
	public void agregarCombatiente(Combatiente combatiente) {
		combatientes.add(combatiente);
	}
	
	public void eliminarCombatiente(Combatiente combatiente) {
		combatientes.remove(combatiente);
	}
	
	public List<Personaje> obtenerPersonajes() {
        List<Personaje> personajes = new ArrayList<>();
        for (Combatiente combatiente : combatientes) {
            if (combatiente instanceof Personaje) {
                personajes.add((Personaje) combatiente);
            } else if (combatiente instanceof Batallon) {
                personajes.addAll(((Batallon) combatiente).obtenerPersonajes());
            }
        }
        return personajes;
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
