package Unidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje implements Combatiente{
	final private String nombre, clase, rango;
	final private int vidaMax, manaMax;
	private int vida, mana;
	//private List<Estado> estados;
	//Constructor
	protected Personaje(String nombre, int vida, int mana, String clase, String rango) {
		this.nombre = nombre;
		this.clase = clase;
		this.rango = rango;
		this.vidaMax = vida;
		this.manaMax = mana;
		//this.estados = new ArrayList<Estado>();
	}
	
	public void recibirDaño(int daño) {
		//implementar
	}
	
	public void gastarMana(int mana) {
		//implementar
	}
	
	public boolean puedePelear() {
		//impolementar
		return true;
	}
/*	
	public void agregarEstado(Estado estado) {
		//implementar
	}
*/
	@Override
	public void luchar(Combatiente enemigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaMuerto() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub
		
	}
	public abstract void pensarAccion(Batallon batallonContrario);
}
