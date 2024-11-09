import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Acciones.LanzarHechizo;
import Acciones.Meditar;
import Acciones.TomarConsumible;
import Unidades.Auror;
import Unidades.Batallon;
import Unidades.Personaje;
import consumible.Consumible;

class AurorTest {

    private Auror auror;
    private Batallon aliados;
    private Batallon oponentes;

    @BeforeEach
    void setUp() {
        auror = new Auror("Harry");
        aliados = new Batallon();
        oponentes = new Batallon();
    }

    @Test
    void testCreacionAuror() {
        assertEquals("Harry", auror.getNombre(), "El nombre debería ser Harry");
        assertEquals(200, auror.getVida(), "La vida inicial debería ser 200");
        assertEquals(200, auror.getMana(), "El mana inicial debería ser 200");
        assertEquals("Auror", auror.getRango(), "El rango debería ser Auror");
    }

    @Test
    void testConsumiblesIniciales() {
        assertTrue(auror.getConsumibles().contains(Consumible.POCION_VIDA), "Debería contener POCION_VIDA");
        assertTrue(auror.getConsumibles().contains(Consumible.POCION_POTENCIADORA), "Debería contener POCION_POTENCIADORA");
    }

    @Test
    void testPensarAccionConConsumible() {
        // Configura el escenario donde el Auror tiene un consumible
        auror.getConsumibles().add(Consumible.POCION_VIDA);

        // Ejecuta la acción
        auror.pensarAccion(aliados, oponentes);

        // Verifica que la acción seleccionada sea TomarConsumible
        assertTrue(auror.getAccion() instanceof TomarConsumible, "La acción debería ser TomarConsumible");
    }

    @Test
    void testPensarAccionConMagiaParaBombardum() {
        // Configura suficiente mana para Bombardum y enemigos en el batallón oponente
        auror.incrementarMana(100); // Asumimos que incrementarMana aumenta el mana actual
        oponentes.agregarPersonaje(new Personaje("Enemigo", 100, 100)); // Añade un enemigo

        // Ejecuta la acción
        auror.pensarAccion(aliados, oponentes);

        // Verifica que la acción seleccionada sea LanzarHechizo y el hechizo sea Bombardum
        assertTrue(auror.getAccion() instanceof LanzarHechizo, "La acción debería ser LanzarHechizo");
        assertEquals("Bombardum", ((LanzarHechizo) auror.getAccion()).getHechizo().getNombre(), "El hechizo debería ser Bombardum");
    }

    @Test
    void testPensarAccionConSeptusembra() {
        // Configura suficiente mana para Septusembra y un enemigo con poca vida en el batallón oponente
        auror.incrementarMana(100);
        Personaje enemigo = new Personaje("Enemigo", 10, 100); // Enemigo con poca vida
        oponentes.agregarPersonaje(enemigo);

        // Ejecuta la acción
        auror.pensarAccion(aliados, oponentes);

        // Verifica que la acción seleccionada sea LanzarHechizo y el hechizo sea Septusembra
        assertTrue(auror.getAccion() instanceof LanzarHechizo, "La acción debería ser LanzarHechizo");
        assertEquals("Septusembra", ((LanzarHechizo) auror.getAccion()).getHechizo().getNombre(), "El hechizo debería ser Septusembra");
    }

    @Test
    void testPensarAccionMeditar() {
        // Configura el escenario donde no hay consumibles ni suficiente magia para hechizos
        auror.setMana(0);

        // Ejecuta la acción
        auror.pensarAccion(aliados, oponentes);

        // Verifica que la acción seleccionada sea Meditar
        assertTrue(auror.getAccion() instanceof Meditar, "La acción debería ser Meditar");
    }
}
