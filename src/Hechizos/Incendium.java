package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class Incendium extends HechizoBase{
	public static final int costo=40;
	Personaje objetivo;
	int turnos;
	
	public Incendium(Personaje lanzador, Personaje objetivo){
		this.nombre = "Incendium";
		this.lanzador = lanzador;
		this.objetivo = objetivo;
		this.dañoBase = 5;
		this.costeMana = 40;
		this.turnos = 5;
		this.descripcion = "Hechizo de area fuego, solo lo pueden utilizar los estudiantes.";
	}
/*	
	Incendium(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana, int turnos){
		this.nombre = "Incendium";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.turnos = turnos;
		this.descripcion = "Hechizo de area fuego, solo lo pueden utilizar los estudiantes.";
	}*/
	
	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		
	}
}
