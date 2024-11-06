package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class Petrificus extends HechizoBase{
	Personaje objetivo;
	private int turnos;
	
	Petrificus(Personaje lanzador, Personaje objetivo){
		this.nombre = "Petrificus";
		this.lanzador = lanzador;
		this.objetivo = objetivo;
		this.dañoBase = 50;
		this.costeMana = 50;
		this.turnos = 4;
		this.descripcion = "Hechizo de petrificacion basico.";
	}
	/*
	Petrificus(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana, int turnos){
		this.nombre = "Petrificus";
		this.lanzador = lanzador;
		this.objetivos = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.turnos = turnos;
		this.descripcion = "Hechizo de petrificacion basico.";
	}*/
	
	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		
	}
}
