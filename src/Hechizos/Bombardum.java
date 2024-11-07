package Hechizos;

import java.util.List;

import Efectos.Agilizado;
import Efectos.Potenciado;
import Efectos.Protegido;
import Unidades.Personaje;

public class Bombardum extends HechizoBase{
	public static final int costo=90;
	public static final String NOMBRE="Bombardum";
	List<Personaje> objetivos;
	
	public Bombardum(Personaje lanzador, List<Personaje> objetivos){
		this.nombre = "Bombardum";
		this.lanzador = lanzador;
		this.objetivos = objetivos;
		this.dañoBase = 400;
		this.costeMana = 90;
		this.descripcion = "Hechizo potente y costoso de area, solo lo pueden usar aurores.";
	}
	/*
	Bombardum(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana){
		this.nombre = "Bombardum";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.descripcion = "Hechizo potente y costoso de area, solo lo pueden usar aurores.";
	}*/
	
	@Override
	public void ejecutar() {
		
		lanzador.gastarMana(costeMana);
		
		int dañoPorPersonaje= dañoBase / objetivos.size();
		
		if( lanzador.tieneEfecto(Potenciado.class))
			dañoBase*=2;
		
		for(Personaje objetivo:objetivos) {
			System.out.println(lanzador+" ha realizado el hechizo "+nombre+"a "+objetivo);
			
			if(objetivo.tieneEfecto(Agilizado.class)) {
				System.out.println(objetivo+" estaba Agilizado y con su suerte evito el ataque");
				continue;
			}
			
			if(objetivo.tieneEfecto(Protegido.class)) {
				System.out.println(objetivo+" estaba Protegido se reduce el daño a un tercio");
				dañoBase/=3;
			}
			
			objetivo.recibirDaño(dañoPorPersonaje);
			System.out.println(objetivo+" ha recibido "+dañoBase+" de daño");
		}
		
	}
}









