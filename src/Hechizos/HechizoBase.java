package Hechizos;

import java.util.List;
import Unidades.Personaje;

public abstract class HechizoBase {
	
	protected Personaje lanzador;
	protected int dañoBase, costeMana;
	protected String nombre;
	protected String descripcion;
	
	
	String getNombre() {
		return this.nombre;
	}
	
	int getCostoMana() {
		return this.costeMana;
	}
	
	int getDañoBase() {
		return this.dañoBase;
	}
	
	public abstract void ejecutar();
	
}
