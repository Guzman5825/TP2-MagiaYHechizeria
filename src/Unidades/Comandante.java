package Unidades;

import Acciones.LanzarHechizo;
import Acciones.Meditar;
import Acciones.TomarConsumible;
import Hechizos.HechizoBase;
import Hechizos.Septusembra;
import consumible.Consumible;
import consumible.FactoryConsumible;

public class Comandante extends Mortifago{
	public Comandante(String nombre){
		super(nombre,200,200,"Comandante");
		consumibles.add(Consumible.OROCRUX);
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
		if( this.tieneSuficenteMagia(Septusembra.NOMBRE) ) {
			HechizoBase h=new Septusembra(this,p);
			accion =new LanzarHechizo (h);
			return ;
		}
		
		// aca iria el otro hechizo;
		
		accion= new Meditar(this);
	}

}
