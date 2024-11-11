package app;

import logger.Logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Unidades.Batallon;
import Unidades.FactoryPersonaje;
import enums.TiposPersonaje;

public class App2 {

    public static void main(String[] args) {
        Logger.agregarMensaje("-----Carga de batallones-----");

    	
    	Batallon batallon1=new Batallon();
    	Batallon batallon2=new Batallon();
    	
    	batallon1.agregarCombatiente(FactoryPersonaje.crearPersonaje("Harry Potter", TiposPersonaje.ESTUDIANTE));
    	batallon1.agregarCombatiente(FactoryPersonaje.crearPersonaje("Hermione Granger", TiposPersonaje.ESTUDIANTE));
    	batallon1.agregarCombatiente(FactoryPersonaje.crearPersonaje("Luna Lovegood", TiposPersonaje.ESTUDIANTE));
    	batallon1.agregarCombatiente(FactoryPersonaje.crearPersonaje("Albus Dumbledore", TiposPersonaje.PROFESOR));
    	batallon1.agregarCombatiente(FactoryPersonaje.crearPersonaje("Severus Snape", TiposPersonaje.PROFESOR));
    	batallon1.agregarCombatiente(FactoryPersonaje.crearPersonaje("Nymphadora Tonks", TiposPersonaje.AUROR));
    	
    	batallon2.agregarCombatiente(FactoryPersonaje.crearPersonaje("Bellatrix Lestrange", TiposPersonaje.SEGUIDOR));
    	batallon2.agregarCombatiente(FactoryPersonaje.crearPersonaje("Lucius Malfoy", TiposPersonaje.SEGUIDOR));
    	batallon2.agregarCombatiente(FactoryPersonaje.crearPersonaje("Fenrir Greyback", TiposPersonaje.SEGUIDOR));
    	batallon2.agregarCombatiente(FactoryPersonaje.crearPersonaje("El Acechador", TiposPersonaje.MAGOOSCURO));
    	batallon2.agregarCombatiente(FactoryPersonaje.crearPersonaje("Lord Voldemort", TiposPersonaje.COMANDANTE));
    	
    	
        Juego juego = new Juego();
        juego.cargarDatos(batallon1,batallon2);

        Logger.agregarMensaje("\n\n-----Iniciando la batalla-----");
        juego.jugar();

        Logger.agregarMensaje("-----Juego Terminado-----");

        Logger.mostrarMensajes();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm");
        String fechaActual = LocalDateTime.now().format(formatter);

        Logger.guardarEnArchivo("logBatalla_" + fechaActual + ".txt");
    }

}
