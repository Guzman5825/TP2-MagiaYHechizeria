package consumible;

import Efectos.Vigorizado;
import Unidades.Personaje;

public class PocionEspectro extends Consumible{

	public PocionEspectro(Personaje p) {
		this.personaje=p;
	}
	
	@Override
	public void activarConsumible() {
		System.out.println(personaje+" ha consumido la pocion vigorizante, añadiendo efecto...");
		personaje.agregarEfecto(new Vigorizado(personaje));
	}

	@Override
	public String getNombre() {
		return "pocionEspectro";
	}

}
