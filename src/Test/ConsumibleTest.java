package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Acciones.TomarConsumible;
import Efectos.Envenenado;
import Unidades.Estudiante;
import Unidades.Personaje;
import consumible.PocionMana;
import consumible.PocionVida;

class ConsumibleTest {

	@Test
	void aumentaVidaCorrespondiente() {
		Personaje personaje = new Estudiante("Harry");
		int vidaEsperada=personaje.getVida();
		personaje.recibirDaño(70);
		personaje.setAccion(new TomarConsumible( new PocionVida(personaje) ) );
		personaje.ejecutarAccion();
		assertEquals(vidaEsperada, personaje.getVida());
	}
	
	@Test
	void aumentaManaCorrespondiente() {
		Personaje personaje = new Estudiante("Harry");
		int manaEsperada=personaje.getMana();
		personaje.gastarMana(70);
		personaje.setAccion(new TomarConsumible( new PocionMana(personaje) ) );
		personaje.ejecutarAccion();
		assertEquals(manaEsperada, personaje.getMana());
	}
	
}
