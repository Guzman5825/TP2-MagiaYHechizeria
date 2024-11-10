package Unidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Efectos.Petrificado;
import Efectos.Protegido;
import Hechizos.*;

public class Batallon implements Combatiente {
	private List<Combatiente> combatientes;
	private List<Personaje> personajesVivos;
	private int indice = 0;
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
	
	
	public List<Personaje> getTodosLosPersonaje(){
		return this.personajesVivos;
	}
	
	////////////////////aca van las funciones que ayudan para 

	public Personaje obtenerPersonajeMenorVida() {
		Personaje personajeMenorVida=null;
		int vidaMenor=1000000;
		for(Personaje p:personajesVivos)
			if(p.getVida()<vidaMenor) {
				personajeMenorVida=p;
				vidaMenor=p.getVida();
			}
				
		return personajeMenorVida;
	}
	
	public boolean hayAurorOComandante() {
		for(Personaje p:personajesVivos)
			if(p instanceof Auror || p instanceof Comandante)
				return true;
		return false;
	}
	
	public Personaje obtenerElPrimerAurorOComandante() {
		for(Personaje p:personajesVivos)
			if(p instanceof Auror || p instanceof Comandante)
				return p;
		return null;
	}
	
	public boolean hayAlgunAurorOComandanteSinPetrificado() {
		for(Personaje p:personajesVivos)
			if(p instanceof Auror || p instanceof Comandante)
				if( !p.tieneEfecto( Petrificado.class))
					return true;
		return false;
	}
	
	public Personaje obtenerElPrimerAurorOComandanteSinPetrificar() {
		for(Personaje p:personajesVivos)
			if(p instanceof Auror || p instanceof Comandante)
				if( !p.tieneEfecto( Petrificado.class))
					return p;
		return null;
	}
	
	public boolean hayEstudianteSinProtego() {
		for(Personaje p:personajesVivos)
			if(p instanceof Estudiante)
				if(!p.tieneEfecto( Protegido.class) )
					return true;
		return false;
	}
	
	public Personaje obtenerPrimerEstudianteSinProtego() {
		for(Personaje p:personajesVivos)
			if(p instanceof Estudiante)
				if(!p.tieneEfecto( Protegido.class) )
					return p;
		return null;
	}
	
	
	public Personaje obtenerPersonajeAleatorio() {
		Random random = new Random(12345);
        int indiceAleatorio = random.nextInt(personajesVivos.size());
        return personajesVivos.get(indiceAleatorio);
	}

	
	public Personaje obtenerPersonajeMayorVida() {
		Personaje personajeMenorVida=null;
		int vidaMayor=0;
		for(Personaje p:personajesVivos)
			if(p.getVida()>vidaMayor) {
				personajeMenorVida=p;
				vidaMayor=p.getVida();
			}
				
		return personajeMenorVida;
	}
	
	public Personaje obtenerPrimerPersonajeMasAltoRangoPosible() {
		for(Personaje p:personajesVivos)
			if(p instanceof Auror || p instanceof Comandante)
				return p;
		for(Personaje p:personajesVivos)
			if(p instanceof Profesor || p instanceof MagoOscuro)
				return p;
		for(Personaje p:personajesVivos)
			if(p instanceof Estudiante || p instanceof Seguidor)
				return p;
		
		return null;
	}

	public Personaje obtenerPrimerPersonajeMasAltoRangoPosibleSinProtego() {
		for(Personaje p:personajesVivos)
			if(p instanceof Auror || p instanceof Comandante)
				if(!p.tieneEfecto(Protegido.class))
					return p;
		for(Personaje p:personajesVivos)
			if(p instanceof Profesor || p instanceof MagoOscuro)
				if(!p.tieneEfecto(Protegido.class))
					return p;
		for(Personaje p:personajesVivos)
			if(p instanceof Estudiante || p instanceof Seguidor)
				if(!p.tieneEfecto(Protegido.class))
					return p;
		
		return null;
	}

	public Personaje obtenerSiguientePersonaje() {
		if (indice >= this.personajesVivos.size())
			indice = indice % this.personajesVivos.size();
		Personaje personajeActual = this.personajesVivos.get(indice);
		indice++;
		return personajeActual;
	}

	
	public void removerPersonajesMuertos() {
	    personajesVivos.removeIf(personaje -> {
	        if (personaje.estaMuerto()) {
	            System.out.println(personaje + " se fue de sabático!!!!!");
	            return true; 
	        }
	        return false;
	    });
	}
	
	public boolean batallonDerrotado() {
		return this.personajesVivos.size()==0;
	}
	
	public int cantidadPersonajesVivos() {
		return this.personajesVivos.size();
	}
	
}
