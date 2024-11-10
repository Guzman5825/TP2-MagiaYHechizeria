package Unidades;

import Acciones.*;
import Hechizos.*;
import consumible.*;


public class Seguidor extends Mortifago{

	public Seguidor(String nombre){
		super(nombre,80,80,"Seguidor");
		consumibles.add(Consumible.POCION_MANA);
		//cambiara pocion espectro
	}

	@Override
	public void pensarAccion(Batallon aliados, Batallon oponentes) {
		
		String consumible=this.obtenerPrimerNombreObjetoUtil();
		if(consumible!=null) {
			Consumible c= FactoryConsumible.crearConsumible(this, consumible);
			accion = new TomarConsumible( c );
			return;
		}
		
		Personaje p=oponentes.obtenerPersonajeMenorVida();
		if( this.tieneSuficenteMagia(Septusembra.NOMBRE) && p.getVida()<=Septusembra.DAÑO ) {
			HechizoBase h=new Septusembra(this,p);
			accion =new LanzarHechizo (h);
			return ;
		}
		
		if( this.tieneSuficenteMagia(Veneficus.NOMBRE) ) {
			p=oponentes.obtenerPrimerPersonajeMasAltoRangoPosible();
			HechizoBase h=new Veneficus(this,p);
			accion =new LanzarHechizo (h);
			return ;
		}
		
		
		accion= new Meditar(this);
	}


}
