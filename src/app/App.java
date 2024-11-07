package app;

public class App {

	public static void main(String[] args) {
		Juego juego=new Juego();
		
		System.out.println("carga de batallones");
		juego.cargarDatos();
		System.out.println("\n\n iniciandop la batalla");
		juego.jugar();
		System.out.println("juegoTerminado");
	}

}
