package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class Protego extends HechizoBase{
	public static final int costo=40;
	private int turnos;
	Personaje objetivo;
	
	public Protego(Personaje lanzador, Personaje objetivos){
		this.nombre = "Protego";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = 0;
		this.costeMana = 40;
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
