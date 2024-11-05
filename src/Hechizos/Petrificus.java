package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class Petrificus extends HechizoBase{
	private int turnos;
	Petrificus(Personaje lanzador, List<Personaje> objetivos){
		this.nombre = "Petrificus";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = 50;
		this.costeMana = 50;
		this.turnos = 4;
		this.descripcion = "Hechizo de petrificacion basico.";
	}
	
	Petrificus(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana, int turnos){
		this.nombre = "Petrificus";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.turnos = turnos;
		this.descripcion = "Hechizo de petrificacion basico.";
	}
	
	@Override
	void ejecutar() {
		// TODO Auto-generated method stub
		
	}
}
