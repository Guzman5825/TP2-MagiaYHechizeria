package Hechizos;

import java.util.List;

import Efectos.Agilizado;
import Efectos.Potenciado;
import Efectos.Protegido;
import Unidades.Auror;
import Unidades.Personaje;
import logger.Logger;

public class Bombardum extends HechizoBase {
	public static final int costo = 90;
	public static final String NOMBRE = "Bombardum";
	private List<Personaje> objetivos;

	public Bombardum(Personaje lanzador, List<Personaje> objetivos) {
		this.nombre = "Bombardum";
		this.lanzador = lanzador;
		this.objetivos = objetivos;
		this.dañoBase = 240;
		this.costeMana = 90;
		this.descripcion = "Hechizo potente y costoso de area, solo lo pueden usar aurores.";
	}
	/*
	 * Bombardum(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int
	 * costeMana){ this.nombre = "Bombardum"; this.lanzador = lanzador;
	 * this.objetivo = objetivos; this.dañoBase = dañoBase; this.costeMana =
	 * costeMana; this.descripcion =
	 * "Hechizo potente y costoso de area, solo lo pueden usar aurores."; }
	 */

	@Override
	public void ejecutar() {

		lanzador.gastarMana(costeMana);

		dañoBase = dañoBase / objetivos.size();

		if (lanzador.tieneEfecto(Potenciado.class))
			dañoBase *= 2;

		for (Personaje objetivo : objetivos) {
			Logger.agregarMensaje(lanzador + " ha realizado el hechizo " + nombre + "a " + objetivo);

			if (objetivo.tieneEfecto(Agilizado.class)) {
				Logger.agregarMensaje(objetivo + " estaba Agilizado y con su suerte evito el ataque");
				continue;
			}

			if (objetivo.tieneEfecto(Protegido.class)) {
				Logger.agregarMensaje(objetivo + " estaba Protegido se reduce el daño a un tercio");
				dañoBase /= 3;
			}

			objetivo.recibirDaño(dañoBase);
			Logger.agregarMensaje(objetivo + " ha recibido " + dañoBase + " de daño");
		}

	}
}
