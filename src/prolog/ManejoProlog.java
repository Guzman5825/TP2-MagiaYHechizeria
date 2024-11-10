package prolog;

import org.jpl7.*;

public class ManejoProlog {
    private static final String FILE_NAME = "prolog/magosvsmortifagos.pl";

    static {
        Query cargarArchivo = new Query("consult('" + FILE_NAME + "')");
        if (!cargarArchivo.hasSolution()) {
            throw new RuntimeException("Error con la carga del archivo prolog");
        } 
    }

    public static boolean puedeLanzarHechizo(String hechizo, int manaPersonaje) {
        Query consulta = new Query("puede_lanzar", new Term[]{
                new Atom(hechizo.toLowerCase()), new org.jpl7.Integer(manaPersonaje)
        });
        return consulta.hasSolution();
    }
}
