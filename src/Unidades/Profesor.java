package Unidades;

import Acciones.LanzarHechizo;
import Acciones.Meditar;
import Acciones.TomarConsumible;
import Hechizos.HechizoBase;
import Hechizos.Septusembra;
import consumible.Consumible;
import consumible.FactoryConsumible;

public class Profesor extends Mago{
	
	public Profesor(String nombre){
		super(nombre,130,130,"Profesor");
		consumibles.add(Consumible.POCION_VIDA);
		consumibles.add(Consumible.POCION_VIDA);
		consumibles.add(Consumible.POCION_VIGORIZANTE);
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
