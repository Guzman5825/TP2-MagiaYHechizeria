package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class Bombardum extends HechizoBase{
	
	Bombardum(Personaje lanzador, List<Personaje> objetivos){
		this.nombre = "Bombardum";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = 50;
		this.costeMana = 50;
		this.descripcion = "Hechizo potente y costoso de area, solo lo pueden usar aurores.";
	}
	
	Bombardum(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana){
		this.nombre = "Bombardum";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.descripcion = "Hechizo potente y costoso de area, solo lo pueden usar aurores.";
	}
	
	@Override
	void ejecutar() {
		// TODO Auto-generated method stub
		
	}
}
