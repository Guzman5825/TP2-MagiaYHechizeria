package consumible;

import Unidades.Personaje;
import logger.Logger;

public class PocionMana extends Consumible {

	public PocionMana(Personaje personaje) {
		this.personaje = personaje;
	}

	@Override
	public void activarConsumible() {
		int manaArecargar = 100;
		Logger.agregarMensaje(personaje + " uso pocion de mana +100MP");
		personaje.ganarMana(manaArecargar);
	}

	@Override
	public String getNombre() {
		return "pocionEnergia";
	}

}
