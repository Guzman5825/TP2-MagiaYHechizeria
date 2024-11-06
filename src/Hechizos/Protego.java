package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class Protego extends HechizoBase{
	private int turnos;
	Personaje objetivo;
	
	Protego(Personaje lanzador, Personaje objetivos){
		this.nombre = "Protego";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = 50;
		this.costeMana = 50;
		this.turnos = 4;
		this.descripcion = "Hechizo de proteccion basico.";
	}
	/*
	Protego(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana, int turnos){
		this.nombre = "Protego";
		this.lanzador = lanzador;
		this.objetivos = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.turnos = turnos;
		this.descripcion = "Hechizo de proteccion basico.";
	}*/
	
	@Override
	public void ejecutar() {
		// TODO Auto-generated method stub
		
	}
}
