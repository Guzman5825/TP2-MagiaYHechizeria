package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class Septusembra extends HechizoBase{
	Septusembra(Personaje lanzador, List<Personaje> objetivos){
		this.nombre = "Septusembra";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = 50;
		this.costeMana = 50;
		this.descripcion = "Hechizo basico ataque.";
	}
	
	Septusembra(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana){
		this.nombre = "Septusembra";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.descripcion = "Hechizo basico ataque..";
	}
	
	@Override
	void ejecutar() {
		// TODO Auto-generated method stub
		
	}
}
