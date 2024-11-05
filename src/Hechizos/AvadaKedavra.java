package Hechizos;

import java.util.List;
import Unidades.Personaje;

public class AvadaKedavra extends HechizoBase{
	AvadaKedavra(Personaje lanzador, List<Personaje> objetivos){
		this.nombre = "AvadaKedavra";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = 50;
		this.costeMana = 50;
		this.descripcion = "Hechizo potente y costoso, solo lo pueden usar comandantes.";
	}
	
	AvadaKedavra(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana){
		this.nombre = "AvadaKedavra";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.descripcion = "Hechizo potente y costoso, solo lo pueden usar comandantes.";
	}
	
	@Override
	void ejecutar() {
		// TODO Auto-generated method stub
		
	}

}
