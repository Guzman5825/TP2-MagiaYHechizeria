package Unidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Batallon implements Combatiente {
	private List<Combatiente> combatientes;
	private List<Personaje> personajesVivos;
	
	public Batallon(){
		this.combatientes = new ArrayList<Combatiente>();
		this.personajesVivos = new ArrayList<Personaje>();
	}
	
	public Batallon(List<Combatiente> combatientes){
		this.combatientes = combatientes;
	}
	
	public void agregarCombatiente(Combatiente combatiente) {
		combatientes.add(combatiente);
	}
	
	public void eliminarCombatiente(Combatiente combatiente) {
		combatientes.remove(combatiente);
	}
	
	public void cargarPersonajesVivos(){
		personajesVivos=obtenerPersonajes();
	}
	
	public List<Personaje> obtenerListaPersonajesVivos(){
		return personajesVivos;
	}
	
	private List<Personaje> obtenerPersonajes() {
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

//	Metodos de la interfaz Combatiente
	public void luchar(Combatiente enemigo) {
		//implementar
	}
	public boolean estaMuerto() {
		//implementar
		return true;
	}
	public void getInfo() {	///esto es para ver como esta internamete da la info
		System.out.println("BATALLON");
		for(Combatiente c:combatientes)
			c.getInfo();
	}
	////////////////////aca van las funciones que ayudan para 

	public Personaje obtenerPersonajeMenorVida() {
		Personaje personajeMenorVida=null;
		int vidaMenor=1000000;
		for(Personaje p:personajesVivos)
			if(p.getVida()<vidaMenor)
				personajeMenorVida=p;
		return personajeMenorVida;
	}
	
	public Personaje obtenerPersonajeAleatorio() {
		Random random = new Random(12345);
        int indiceAleatorio = random.nextInt(personajesVivos.size());
        return personajesVivos.get(indiceAleatorio);
	}
	
	
}
