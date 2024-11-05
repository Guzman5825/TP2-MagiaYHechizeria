package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class Incendium extends HechizoBase{
	private int turnos;
	Incendium(Personaje lanzador, List<Personaje> objetivos){
		this.nombre = "Incendium";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = 50;
		this.costeMana = 50;
		this.turnos = 4;
		this.descripcion = "Hechizo de area fuego, solo lo pueden utilizar los estudiantes.";
	}
	
	Incendium(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana, int turnos){
		this.nombre = "Incendium";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.turnos = turnos;
		this.descripcion = "Hechizo de area fuego, solo lo pueden utilizar los estudiantes.";
	}
	
	@Override
	void ejecutar() {
		// TODO Auto-generated method stub
		
	}
}
