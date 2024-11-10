package Unidades;

import java.util.ArrayList;
import java.util.List;

import Acciones.Accion;
import Efectos.*;
import consumible.*;
import logger.Logger;
import prolog.ManejoProlog;

public abstract class Personaje implements Combatiente {
	final protected String nombre, clase, rango;
	final protected int vidaMax, manaMax;
	protected int vida, mana;
	protected List<Efecto> efectos;
	protected Accion accion;
	protected List<String> consumibles;

	// Constructor
	protected Personaje(String nombre, int vida, int mana, String clase, String rango) {
		this.nombre = nombre;
		this.clase = clase;
		this.rango = rango;
		this.vidaMax = vida;
		this.vida = vida;
		this.manaMax = mana;
		this.mana = mana;
		this.efectos = new ArrayList<Efecto>();
		this.consumibles = new ArrayList<String>();
	}

	public void recibirDaño(int daño) {

		this.vida -= daño;
	}

	public void ganarVida(int vida) {
		this.vida += vida;
		if (this.vida > vidaMax)
			this.vida = vidaMax;
	}

	public void gastarMana(int mana) {
		this.mana -= mana;
	}

	public void ganarMana(int mana) {
		this.mana += mana;
		if (this.mana > manaMax)
			this.mana = manaMax;
	}

	public boolean puedePelear() {
		if (estaMuerto() || tieneEfecto(Petrificado.class)) /// implementar otras funciones
			return false;
		return true;
	}

	public boolean tienePocaVida() {
		return ((int) vidaMax * 0.2) >= vida;
	}

	public boolean tienePocoMana() {
		return 40 >= mana;
	}

	public boolean tieneEfecto(Class<? extends Efecto> tipoEfecto) {
		for (Efecto efecto : efectos)
			if (tipoEfecto.isInstance(efecto))
				return true;

		return false;
	}

	public boolean tieneConsumible(String objeto) {
		for (String objetoActual : consumibles)
			if (objetoActual.equalsIgnoreCase(objeto)) /// modificar despúes si es asi
				return true;
		return false;
	}

	public boolean tieneSuficenteMana(String nombreHechizo) {
		// importante pasar todo el nombre del hechizo a minuscula
		return ManejoProlog.puedeLanzarHechizo(nombreHechizo.toLowerCase(), this.mana);
	}

	public String obtenerPrimerNombreObjetoUtil() {
		String nombreConsumible = null;

		for (String consumible : consumibles)
			if (esUtilUsar(consumible))
				return consumible;
		return nombreConsumible;
	}

	private boolean esUtilUsar(String consumible) {
		if (consumible.equalsIgnoreCase(Consumible.POCION_VIDA))
			if (this.tienePocaVida())
				return true;

		if (consumible.equalsIgnoreCase(Consumible.POCION_MANA))
			if (this.tienePocoMana())
				return true;

		if (consumible.equalsIgnoreCase(Consumible.POCION_VIGORIZANTE))
			if (!tieneEfecto(Vigorizado.class))
				return true;

		if (consumible.equalsIgnoreCase(Consumible.POCION_POTENCIADORA))
			if (!tieneEfecto(Potenciado.class))
				return true;

		if (consumible.equalsIgnoreCase(Consumible.POCION_ESPECTRO))
			if (!tieneEfecto(Agilizado.class))
				return true;

		return false;
	}

	public void agregarEfecto(Efecto e) {
		efectos.add(e);
	}

	public void removerEfectosSinTurnos() {
		int i = 0;
		while (i < efectos.size()) {
			Efecto e = efectos.get(i);
			if (!e.hayTurno()) {
				efectos.remove(i);
				i--;
			}
			i++;
		}
	}

	public void bajarTurnosEfectos() {
		for (Efecto e : efectos)
			e.bajarTurno();
	}

	public void activarEfectos() {
		for (Efecto e : efectos)
			e.activar();
	}

	@Override
	public void luchar(Combatiente enemigo) {
	}

	@Override
	public boolean estaMuerto() {
		return this.vida <= 0;
	}

	public void imprimirInfo() {
	    String info = String.format(
	            "%-15s  HP:%3d/%3d EM:%3d/%3d  %s-%s",
	            nombre, vida, vidaMax, mana, manaMax, clase, rango
	        );
	        info += "\nConsumible:" + consumibles;
	        
	    Logger.agregarMensaje(info);

	}
	
	public String getInfo() {
	    String info = String.format(
	        "%-15s  HP:%3d/%3d EM:%3d/%3d  %s-%s",
	        nombre, vida, vidaMax, mana, manaMax, clase, rango
	    );
	    info += "\nConsumible:" + consumibles;
	    
	    return info;
	}


	public abstract void pensarAccion(Batallon aliados, Batallon oponentes);

	public void ejecutarAccion() {
		this.accion.ejecutar();
	}

	public void accionar(Batallon aliados, Batallon oponentes) {
		this.activarEfectos();

		if (puedePelear()) {
			pensarAccion(aliados, oponentes);
			accion.ejecutar();
		}

		this.bajarTurnosEfectos();
		this.removerEfectosSinTurnos();
	}

	public void quitarDeListaDeObjetos(String nombreObjeto) {
		consumibles.remove(nombreObjeto);
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public Accion getAccion() {
		return accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getRango() {
		return this.rango;
	}
	
	public int getVidaMax() {
		return this.vidaMax;
	}
}
