package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class Serpensortia extends HechizoBase{
	private int turnos;
	Serpensortia(Personaje lanzador, List<Personaje> objetivos){
		this.nombre = "Serpensortia";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = 50;
		this.costeMana = 50;
		this.turnos = 4;
		this.descripcion = "Hechizo de area venenoso, solo lo pueden utilizar los seguidores.";
	}
	
	Serpensortia(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana, int turnos){
		this.nombre = "Serpensortia";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.turnos = turnos;
		this.descripcion = "Hechizo de area venenoso, solo lo pueden utilizar los seguidores.";
	}
	
	@Override
	void ejecutar() {
		// TODO Auto-generated method stub
		
	}
}
