package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Unidades.Estudiante;
import prolog.ManejoProlog;

class PrologTest {

	@Test
	void testPuedeLanzarConSuficienteMana() {
		Estudiante harry = new Estudiante("Harry");
		harry.setMana(100);
		assertTrue(ManejoProlog.puedeLanzarHechizo("septusembra", harry.getMana()));
	}

	@Test
	void testPuedeLanzarInsuficienteMana() {
		Estudiante harry = new Estudiante("Harry");
		harry.setMana(10);
		assertFalse(ManejoProlog.puedeLanzarHechizo("septusembra", harry.getMana()));
	}

}
