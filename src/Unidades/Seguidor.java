package Unidades;

import Acciones.*;
import Hechizos.*;

public class Seguidor extends Mortifago{
	public Seguidor(String nombre){
		super(nombre,80,80,"Seguidor");
	}

	@Override
	protected void pensarAccion(Batallon aliados, Batallon oponentes) {
		Personaje p=oponentes.obtenerPersonajeMenorVida();
		HechizoBase h=new Septusembra(this,p);
		this.setAccion(new LanzarHechizo (h) );
	}
}
