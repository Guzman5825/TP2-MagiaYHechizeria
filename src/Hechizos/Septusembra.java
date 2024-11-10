package Hechizos;

import java.util.List;

import Efectos.Agilizado;
import Efectos.Potenciado;
import Efectos.Protegido;
import Unidades.Personaje;
import logger.Logger;

public class Septusembra extends HechizoBase {
	public static final int costo = 30;
	public static final String NOMBRE = "Septusembra";
	public static final int DAÑO = 30;
	private Personaje objetivo;

	public Septusembra(Personaje lanzador, Personaje oponente) {
		this.nombre = "Septusembra";
		this.lanzador = lanzador;
		this.objetivo = oponente;
		this.dañoBase = 30;
		this.costeMana = 30;
		this.descripcion = "Hechizo basico ataque.";
	}

	/*
	 * Septusembra(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int
	 * costeMana){ this.nombre = "Septusembra"; this.lanzador = lanzador;
	 * this.objetivo = objetivos; this.dañoBase = dañoBase; this.costeMana =
	 * costeMana; this.descripcion = "Hechizo basico ataque.."; }
	 */

	@Override
	public void ejecutar() {
		Logger.agregarMensaje(lanzador + " ha realizado el hechizo " + nombre + " a " + objetivo);
		lanzador.gastarMana(costeMana);

		if (lanzador.tieneEfecto(Potenciado.class))
			dañoBase *= 2;

		if (objetivo.tieneEfecto(Agilizado.class)) {
			Logger.agregarMensaje(objetivo + " estaba Agilizado y con su suerte evito el ataque");
			return;
		}

		if (objetivo.tieneEfecto(Protegido.class)) {
			Logger.agregarMensaje(objetivo + " estaba Protegido se reduce el daño a un tercio");
			dañoBase /= 3;
		}

		Logger.agregarMensaje(objetivo + " ha recibido " + dañoBase + " de daño");
		objetivo.recibirDaño(dañoBase);
	}
}
