package Acciones;

import Hechizos.HechizoBase;
import Unidades.*;

public class LanzarHechizo implements Accion{
	private HechizoBase hechizo;
	
	public LanzarHechizo(HechizoBase hechizo){
		this.hechizo=hechizo;
	}
	
	@Override
	public void ejecutar() {
		hechizo.ejecutar();
	}
}
