package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Efectos.*;
import Unidades.Auror;
import Unidades.Estudiante;
import Unidades.Personaje;

class EfectosTest {

	@Test
	void dañoPorEnvenamiento() {
		Personaje personaje = new Estudiante("Harry");

		int vidaInicial = personaje.getVida();
		personaje.agregarEfecto(new Envenenado(personaje));
		personaje.activarEfectos();

		int vidaEsperada = vidaInicial - 10;

		assertEquals(vidaEsperada, personaje.getVida());
	}

	@Test
	void dañoPorEnvenamientoAcumulado() {
		Personaje personaje = new Estudiante("Harry");

		int vidaInicial = personaje.getVida();
		personaje.agregarEfecto(new Envenenado(personaje));
		personaje.agregarEfecto(new Envenenado(personaje));
		personaje.agregarEfecto(new Envenenado(personaje));
		personaje.activarEfectos();

		int vidaEsperada = vidaInicial - 30;

		assertEquals(vidaEsperada, personaje.getVida());
	}

	@Test
	void dañoPorQuemadura() {
		Personaje personaje = new Estudiante("Harry");

		int vidaInicial = personaje.getVida();
		personaje.agregarEfecto(new Quemado(personaje));
		personaje.activarEfectos();

		int vidaEsperada = vidaInicial - 15;

		assertEquals(vidaEsperada, personaje.getVida());
	}

	@Test
	void estaPetrificado() {
		Personaje personaje = new Estudiante("Harry");
		boolean esperado = true;
		personaje.agregarEfecto(new Petrificado(personaje));
		assertEquals(esperado, personaje.tieneEfecto(Petrificado.class));
	}

	@Test
	void estaPotenciado() {
		Personaje personaje = new Estudiante("Harry");
		boolean esperado = true;
		personaje.agregarEfecto(new Potenciado(personaje));
		assertEquals(esperado, personaje.tieneEfecto(Potenciado.class));
	}

	@Test
	void estaAgilizado() {
		Personaje personaje = new Estudiante("Harry");
		boolean esperado = true;
		personaje.agregarEfecto(new Agilizado(personaje));
		assertEquals(esperado, personaje.tieneEfecto(Agilizado.class));
	}

	@Test
	void estaProtegido() {
		Personaje personaje = new Estudiante("Harry");
		boolean esperado = true;
		personaje.agregarEfecto(new Protegido(personaje));
		assertEquals(esperado, personaje.tieneEfecto(Protegido.class));
	}

	@Test
	void aumentoDeVidaPorEstadoVigorizado() {
		Personaje personaje = new Estudiante("Harry");
		int vidaInicial = personaje.getVida();

		personaje.recibirDaño(30);
		personaje.agregarEfecto(new Vigorizado(personaje));
		personaje.activarEfectos();

		int vidaEsperada = vidaInicial - 20;

		assertEquals(vidaEsperada, personaje.getVida());
	}

}
