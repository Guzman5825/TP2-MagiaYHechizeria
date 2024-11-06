package consumible;

import Unidades.Personaje;

public class FactoryConsumible {
	public static Consumible crearConsumible(Personaje p,String nombreConsumible) {
		if(nombreConsumible.equalsIgnoreCase("pocionVida")) 
			return new PocionVida(p);
		if(nombreConsumible.equalsIgnoreCase("pocionEnergia")) 
			return new PocionEnergia(p);
		return null;
	}
}
