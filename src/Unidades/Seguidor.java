package Unidades;

import Acciones.*;
import Hechizos.*;
import consumible.FactoryConsumible;

public class Seguidor extends Mortifago{
	public Seguidor(String nombre){
		super(nombre,80,80,"Seguidor");
		this.consumibles.add("porcionMana");
	}

	@Override
	public void pensarAccion(Batallon aliados, Batallon oponentes) {
		
		String consumible=this.obtenerPrimerNombreObjetoUtil();
		if(consumible!=null) {
			accion= new TomarConsumible( FactoryConsumible.crearConsumible(this, consumible) );
			return;
		}
		
		Personaje p=oponentes.obtenerPersonajeMenorVida();
		HechizoBase h=new Septusembra(this,p);
		this.setAccion(new LanzarHechizo (h) );
	}
}
