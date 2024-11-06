package Unidades;

import Acciones.LanzarHechizo;
import Hechizos.HechizoBase;
import Hechizos.Septusembra;

public class Comandante extends Mortifago{
	public Comandante(String nombre){
		super(nombre,200,200,"Comandante");
	}

	@Override
	protected void pensarAccion(Batallon aliados, Batallon oponentes) {
		Personaje p=oponentes.obtenerPersonajeMenorVida();
		HechizoBase h=new Septusembra(this,p);
		this.setAccion(new LanzarHechizo (h) );
	}

}
