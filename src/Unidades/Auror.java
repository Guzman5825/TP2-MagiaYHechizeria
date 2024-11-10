package Unidades;

import java.util.List;

import Acciones.LanzarHechizo;
import Acciones.Meditar;
import Acciones.TomarConsumible;
import Hechizos.*;
import consumible.Consumible;
import consumible.FactoryConsumible;

public class Auror extends Mago {
	public Auror(String nombre) {
		super(nombre, 200, 200, "Auror");
		consumibles.add(Consumible.POCION_VIDA);
		consumibles.add(Consumible.POCION_POTENCIADORA);
	}

	@Override
	public void pensarAccion(Batallon aliados, Batallon oponentes) {

		String consumible = this.obtenerPrimerNombreObjetoUtil();

		if (consumible != null) {
			Consumible c = FactoryConsumible.crearConsumible(this, consumible);
			accion = new TomarConsumible(c);
			return;
		}

		if (this.tieneSuficenteMagia(Bombardum.NOMBRE)) {
			List<Personaje> ps = oponentes.getTodosLosPersonaje();
			HechizoBase h = new Bombardum(this, ps);
			accion = new LanzarHechizo(h);
			return;
		}

		Personaje p = oponentes.obtenerPersonajeMenorVida();
		if (this.tieneSuficenteMagia(Septusembra.NOMBRE) && p.getVida() <= Septusembra.DAÑO) {
			HechizoBase h = new Septusembra(this, p);
			accion = new LanzarHechizo(h);
			return;
		}

		// aca iria el otro hechizo;

		accion = new Meditar(this);
	}

}
