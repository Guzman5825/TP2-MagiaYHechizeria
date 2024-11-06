package Hechizos;

import java.util.List;

import Efectos.Envenenado;
import Unidades.Personaje;

public class Veneficus extends HechizoBase{
	public static final int costo=40;
	Personaje objetivo;
	private int turnos;
	
	public Veneficus(Personaje lanzador, Personaje objetivo){
		this.nombre = "Veneficus";
		this.lanzador = lanzador;
		this.objetivo = objetivo;
		this.dañoBase = 10;
		this.costeMana = 40;
		this.turnos = 4;
		this.descripcion = "Hechizo de area venenoso, solo lo pueden utilizar los seguidores.";
	}
	/*
	Serpensortia(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana, int turnos){
		this.nombre = "Serpensortia";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.turnos = turnos;
		this.descripcion = "Hechizo de area venenoso, solo lo pueden utilizar los seguidores.";
	}
	*/
	@Override
	public void ejecutar() {
		System.out.println(lanzador+" ha realizado el hechizo "+nombre);
		lanzador.gastarMana(costeMana);
		objetivo.recibirDaño(dañoBase);
		System.out.println(objetivo+" ha recibido "+dañoBase+" de daño");
		objetivo.agregarEfecto(new Envenenado(objetivo));
		
	}
}
