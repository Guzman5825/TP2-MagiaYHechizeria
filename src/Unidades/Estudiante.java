package Unidades;

import Acciones.LanzarHechizo;
import Acciones.Meditar;
import Acciones.TomarConsumible;
import Hechizos.HechizoBase;
import Hechizos.Incendium;
import Hechizos.Septusembra;
import Hechizos.Veneficus;
import consumible.Consumible;
import consumible.FactoryConsumible;

public class Estudiante extends Mago {
	public Estudiante(String nombre) {
		super(nombre, 80, 80, "Estudiante");
		consumibles.add(Consumible.POCION_VIDA);
		consumibles.add(Consumible.POCION_VIDA);
	}

	@Override
	public void pensarAccion(Batallon aliados, Batallon oponentes) {

		String consumible = this.obtenerPrimerNombreObjetoUtil();
		if (consumible != null) {
			Consumible c = FactoryConsumible.crearConsumible(this, consumible);
			accion = new TomarConsumible(c);
			return;
		}

		Personaje p = oponentes.obtenerPersonajeMenorVida();
		if (this.tieneSuficenteMagia(Septusembra.NOMBRE) && p.getVida() <= Septusembra.DAÑO) {
			HechizoBase h = new Septusembra(this, p);
			accion = new LanzarHechizo(h);
			return;
		}

		if (this.tieneSuficenteMagia(Incendium.NOMBRE)) {
			p = oponentes.obtenerPrimerPersonajeMasAltoRangoPosible();
			HechizoBase h = new Incendium(this, p);
			accion = new LanzarHechizo(h);
			return;
		}

		accion = new Meditar(this);
	}

}
