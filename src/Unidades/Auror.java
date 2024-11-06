package Unidades;

import Acciones.LanzarHechizo;
import Hechizos.HechizoBase;
import Hechizos.Septusembra;

public class Auror extends Mago{
	public Auror(String nombre){
		super(nombre,200,200,"Auror");
	}

	@Override
	public void pensarAccion(Batallon aliados, Batallon oponentes) {
		Personaje p=oponentes.obtenerPersonajeMenorVida();
		HechizoBase h=new Septusembra(this,p);
		this.setAccion(new LanzarHechizo (h) );
	}


}
