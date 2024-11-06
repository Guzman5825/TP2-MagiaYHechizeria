package Unidades;

import Acciones.LanzarHechizo;
import Hechizos.HechizoBase;
import Hechizos.Septusembra;

public class Profesor extends Mago{
	
	public Profesor(String nombre){
		super(nombre,130,130,"Profesor");
	}

	@Override
	public void pensarAccion(Batallon aliados, Batallon oponentes) {
		Personaje p=oponentes.obtenerPersonajeMenorVida();
		HechizoBase h=new Septusembra(this,p);
		this.setAccion(new LanzarHechizo (h) );
	}
}
