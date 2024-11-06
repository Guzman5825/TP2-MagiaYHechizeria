package consumible;

import Unidades.Personaje;

public class PocionEnergia extends Consumible{

	
	public PocionEnergia(Personaje personaje) {
		this.personaje=personaje;
	}

	@Override
	public void activarConsumible() {
		int manaArecargar=100;
		System.out.println(personaje+" +100EM");
		personaje.ganarMana(manaArecargar);
	}

	@Override
	public String getNombre() {
		return "pocionEnergia";
	}
	

}
