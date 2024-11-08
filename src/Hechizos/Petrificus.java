package Hechizos;

import java.util.List;

import Efectos.Petrificado;
import Unidades.Personaje;

public class Petrificus extends HechizoBase{
	public static final int costo=50;
	public static final String NOMBRE="Petrificus";
	Personaje objetivo;
	private int turnos;
	
	public Petrificus(Personaje lanzador, Personaje objetivo){
		this.nombre = "Petrificus";
		this.lanzador = lanzador;
		this.objetivo = objetivo;
		this.dañoBase = 0;
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
		System.out.println(lanzador+" ha realizado el hechizo "+nombre+" a "+objetivo);
		lanzador.gastarMana(costeMana);
		
		objetivo.agregarEfecto(new Petrificado(objetivo));
	}
}
