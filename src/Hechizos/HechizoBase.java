package Hechizos;


import java.util.List;
import Unidades.Personaje;

public abstract class HechizoBase {
	protected Personaje lanzador;
	protected List<Personaje> objetivo;
	protected int dañoBase, costeMana;
	protected String nombre;
	protected String descripcion;
	
	
	String getNombre() {
		//implementar
		return "";
	}
	
	int getCostoMana() {
		//implementar
		return 1;
	}
	
	int getDañoBase() {
		//implementar
		return 1;
	}
	
	abstract void ejecutar();
}
