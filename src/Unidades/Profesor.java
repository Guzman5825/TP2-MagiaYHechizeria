package Unidades;

import Acciones.LanzarHechizo;
import Acciones.Meditar;
import Acciones.TomarConsumible;
import Hechizos.HechizoBase;
import Hechizos.Petrificus;
import Hechizos.Protego;
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
		
		//cambiarlo luego si hay auror que este habilitado
		Personaje p;
		
		if( this.tieneSuficenteMagia(Petrificus.NOMBRE)  && oponentes.hayAlgunAurorOComandanteSinPetrificado() ) {
			p=oponentes.obtenerElPrimerAurorOComandanteSinPetrificar();
			accion =new LanzarHechizo (new Petrificus(this,p));
			return ;
		}
		
		if( this.tieneSuficenteMagia(Protego.NOMBRE) ) {
			p=aliados.obtenerPrimerPersonajeMasAltoRangoPosibleSinProtego();
			accion =new LanzarHechizo (new Protego(this,p));
			return ;
		}
		
		// lo mas intelegiten es usar septusembra si el un enemigo tiene poca vida como para incapacitarlo
		p=oponentes.obtenerPersonajeMenorVida();
		if( this.tieneSuficenteMagia(Septusembra.NOMBRE) && p.getVida()<=Septusembra.DAÑO ) {
			accion =new LanzarHechizo ( new Septusembra(this,p) );
			return ;
		}
		
		// aca iria el otro hechizo;
		
		accion= new Meditar(this);
	}

}
