package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class Septusembra extends HechizoBase{
	Personaje oponente;
	
	public Septusembra(Personaje lanzador, Personaje oponente){
		this.nombre = "Septusembra";
		this.lanzador = lanzador;
		this.oponente = oponente;
		this.dañoBase = 50;
		this.costeMana = 50;
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
		oponente.recibirDaño(dañoBase);
		System.out.println(oponente+" ha recibido "+dañoBase+" de daño");
		
	}
}
