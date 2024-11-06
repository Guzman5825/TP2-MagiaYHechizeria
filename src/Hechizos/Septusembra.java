package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class Septusembra extends HechizoBase{
	public static final int costo=30;
	Personaje objetivo;
	
	public Septusembra(Personaje lanzador, Personaje oponente){
		this.nombre = "Septusembra";
		this.lanzador = lanzador;
		this.objetivo = oponente;
		this.dañoBase = 30;
		this.costeMana = 30;
		this.descripcion = "Hechizo basico ataque.";
	}
	
	/*
	Septusembra(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana){
		this.nombre = "Septusembra";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.descripcion = "Hechizo basico ataque..";
	}*/
	
	@Override
	public void ejecutar() {
		System.out.println(lanzador+" ha realizado el hechizo "+nombre);
		lanzador.gastarMana(costeMana);
		objetivo.recibirDaño(dañoBase);
		System.out.println(objetivo+" ha recibido "+dañoBase+" de daño");
		
	}
}
