package consumible;

import Unidades.Personaje;

public class PocionMana extends Consumible{

	public PocionMana(Personaje personaje) {
		this.personaje=personaje;
	}

	@Override
	public void activarConsumible() {
		int manaArecargar=100;
		System.out.println(personaje+" +100MP");
		personaje.ganarMana(manaArecargar);
	}

	@Override
	public String getNombre() {
		return "pocionEnergia";
	}
	

}
