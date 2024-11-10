package consumible;

import Unidades.Personaje;

public class FactoryConsumible {
	public static Consumible crearConsumible(Personaje p, String nombreConsumible) {
		if (nombreConsumible.equalsIgnoreCase(Consumible.POCION_VIDA))
			return new PocionVida(p);
		if (nombreConsumible.equalsIgnoreCase(Consumible.POCION_MANA))
			return new PocionMana(p);

		if (nombreConsumible.equalsIgnoreCase(Consumible.POCION_POTENCIADORA))
			return new PocionPotenciadora(p);
		if (nombreConsumible.equalsIgnoreCase(Consumible.POCION_ESPECTRO))
			return new PocionEspectro(p);
		if (nombreConsumible.equalsIgnoreCase(Consumible.POCION_VIGORIZANTE))
			return new PocionVigorizante(p);

		return null;
	}
}
