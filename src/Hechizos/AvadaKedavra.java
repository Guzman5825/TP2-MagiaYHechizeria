package Hechizos;

import Efectos.Agilizado;
import Unidades.Personaje;
import logger.Logger;

public class AvadaKedavra extends HechizoBase {
	public static final int costo = 80;
	public static final String NOMBRE = "AvadaKedavra";

	private Personaje objetivo;

	public AvadaKedavra(Personaje lanzador, Personaje objetivo) {
		this.nombre = "AvadaKedavra";
		this.lanzador = lanzador;
		this.objetivo = objetivo;
		this.dañoBase = 1000; 
		this.costeMana = 80;
		this.descripcion = "Hechizo potente y costoso, solo lo pueden usar comandantes.";
	}

	@Override
	public void ejecutar() {
		if(objetivo.equals(lanzador)) {
			Logger.agregarMensaje("No puede lanzarse ese hechizo a si mismo");
			return;
		}
		
		Logger.agregarMensaje(lanzador + " ha realizado el hechizo " + nombre + " a " + objetivo);
		lanzador.gastarMana(costeMana); 

		if (objetivo.tieneEfecto(Agilizado.class)) {
			Logger.agregarMensaje(objetivo + " estaba Agilizado y con su suerte evito el ataque");
			return;
		}

		objetivo.recibirDaño(dañoBase);
		Logger.agregarMensaje(objetivo + " ha recibido " + dañoBase + " de daño");
	}

}
