package Unidades;

import Acciones.LanzarHechizo;
import Hechizos.HechizoBase;
import Hechizos.Septusembra;

public class Estudiante extends Mago{
	public Estudiante(String nombre){
		super(nombre,80,80,"Estudiante");
	}

	@Override
	public void pensarAccion(Batallon aliados, Batallon oponentes) {
		Personaje p=oponentes.obtenerPersonajeMenorVida();
		HechizoBase h=new Septusembra(this,p);
		this.setAccion(new LanzarHechizo (h) );
	}

}
