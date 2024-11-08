package Hechizos;

import Efectos.Agilizado;
import Unidades.Personaje;

public class AvadaKedavra extends HechizoBase{
	public static final int costo=80;
	public static final String NOMBRE="AvadaKedavra";
	
	Personaje objetivo;
	
	public AvadaKedavra(Personaje lanzador, Personaje objetivo){
		this.nombre = "AvadaKedavra";
		this.lanzador = lanzador;
		this.objetivo = objetivo;
		this.dañoBase = 1000;	//esto es instakill
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
		System.out.println(lanzador+" ha realizado el hechizo "+nombre+" a "+objetivo);
		lanzador.gastarMana(costeMana);		///ejecutar mana puede estar por fuera de esta funcion
		
		if(objetivo.tieneEfecto(Agilizado.class)) {
			System.out.println(objetivo+" estaba Agilizado y con su suerte evito el ataque");
			return;
		}
		
		objetivo.recibirDaño(dañoBase);
		System.out.println(objetivo+" ha recibido "+dañoBase+" de daño");
	}

}
