package prolog;

import org.jpl7.*;

import Unidades.Batallon;
import Unidades.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManejoProlog {
    private static final String FILE_NAME = "C:/Users/nicol/programming-paradigms/TP2-MagiaYHechizeria/src/prolog/magosvsmortifagos.pl";

    // Bloque static para cargar el archivo Prolog al iniciar la clase
    static {
        Query cargarArchivo = new Query("consult('" + FILE_NAME + "')");
        if (!cargarArchivo.hasSolution()) {
            System.out.println("Error al cargar el archivo Prolog.");
        } 
    }

    // Método para verificar si el personaje puede lanzar un hechizo con el mana actual
    public static boolean puedeLanzarHechizo(String hechizo, int manaPersonaje) {
        Query consulta = new Query("puede_lanzar", new Term[]{
                new Atom(hechizo.toLowerCase()), new org.jpl7.Integer(manaPersonaje)
        });
        return consulta.hasSolution();
    }

    // Método para obtener una lista de hechizos lanzables según el mana actual del personaje
    public static List<String> obtenerHechizosLanzables(int manaPersonaje) {
        Query consulta = new Query("lista_hechizos_lanzables", new Term[]{
                new org.jpl7.Integer(manaPersonaje), new Variable("Hechizos")
        });

        List<String> hechizosLanzables = new ArrayList<>();
        if (consulta.hasSolution()) {
            Map<String, Term> solucion = consulta.oneSolution();
            Term listaHechizos = solucion.get("Hechizos");
            for (Term hechizo : listaHechizos.toTermArray()) {
                hechizosLanzables.add(hechizo.name());
            }
        }
        return hechizosLanzables;
    }

    // Método para obtener una lista de enemigos derrotables dado un ataque y un batallón de enemigos
    public static List<String> obtenerEnemigosDerrotables(int ataque, Batallon batallonEnemigos) {
        // Convierte la lista de enemigos del batallón en una lista de términos en Prolog
        StringBuilder enemigosProlog = new StringBuilder("[");
        for (Personaje enemigo : batallonEnemigos.obtenerListaPersonajesVivos()) {
            enemigosProlog.append(String.format("(%s, %d),", enemigo.getNombre(), enemigo.getVidaActual()));
        }
        enemigosProlog.deleteCharAt(enemigosProlog.length() - 1).append("]");
        Term listaEnemigosTerm = Term.textToTerm(enemigosProlog.toString());

        // Crea y ejecuta la consulta en Prolog
        Query consulta = new Query("personaje_derrotable", new Term[]{
                new org.jpl7.Integer(ataque), listaEnemigosTerm, new Variable("EnemigosDerrotables")
        });

        // Lista para almacenar los nombres de los enemigos derrotables
        List<String> enemigosDerrotables = new ArrayList<>();
        if (consulta.hasSolution()) {
            Map<String, Term> solucion = consulta.oneSolution();
            Term listaEnemigosDerrotables = solucion.get("EnemigosDerrotables");
            for (Term enemigo : listaEnemigosDerrotables.toTermArray()) {
                enemigosDerrotables.add(enemigo.name());
            }
        }
        return enemigosDerrotables;
    }

    // Clase auxiliar Enemigo para manejar las tuplas de enemigos y sus vidas
    public static class Enemigo {
        private final String nombre;
        private final int vidaActual;

        public Enemigo(String nombre, int vidaActual) {
            this.nombre = nombre;
            this.vidaActual = vidaActual;
        }

        public String getNombre() {
            return nombre;
        }

        public int getVidaActual() {
            return vidaActual;
        }
    }
}