package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class AvadaKedavra extends HechizoBase{
	public static final int costo=80;
	Personaje objetivo;
	
	AvadaKedavra(Personaje lanzador, Personaje objetivo){
		this.nombre = "AvadaKedavra";
		this.lanzador = lanzador;
		this.objetivo = objetivo;
		this.dañoBase = 400;
		this.costeMana = 80;
		this.descripcion = "Hechizo potente y costoso, solo lo pueden usar comandantes.";
	}
	
	/*
	AvadaKedavra(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana){
		this.nombre = "AvadaKedavra";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.descripcion = "Hechizo potente y costoso, solo lo pueden usar comandantes.";
	}*/
	
	@Override
	public void ejecutar() {
		System.out.println(lanzador+" ha realizado el hechizo "+nombre);
		lanzador.gastarMana(costeMana);
		objetivo.recibirDaño(dañoBase);
		System.out.println(objetivo+" ha recibido "+dañoBase+" de daño");
	}

}
