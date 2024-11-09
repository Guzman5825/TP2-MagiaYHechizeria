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
}
