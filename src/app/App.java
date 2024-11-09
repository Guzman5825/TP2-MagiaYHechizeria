package app;

public class App {

	public static void main(String[] args) {
		Juego juego=new Juego();
		
		System.out.println("-----Carga de batallones-----");
		juego.cargarDatos();
		System.out.println("\n\n-----Iniciando la batalla-----");
		juego.jugar();
		System.out.println("-----Juego Terminado-----");
	}

}
