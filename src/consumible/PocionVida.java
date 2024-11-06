package consumible;

import Unidades.Personaje;

public class PocionVida extends Consumible{

	public PocionVida(Personaje p) {
		this.personaje=p;
	}
	
	@Override
	public void activarConsumible() {
		int vidaArecargar=100;
		System.out.println(personaje+" +100HP");
		personaje.ganarMana(vidaArecargar);
	}

	@Override
	public String getNombre() {
		return "pocionVida";
	}

}
