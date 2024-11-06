package consumible;

import Unidades.Personaje;

public abstract class Consumible {
	protected Personaje personaje;
	
	public void usar() {
		activarConsumible();
		personaje.quitarDeListaDeObjetos(getNombre());
	}
	
	
	abstract public void activarConsumible();
	abstract public String getNombre();
	
}
