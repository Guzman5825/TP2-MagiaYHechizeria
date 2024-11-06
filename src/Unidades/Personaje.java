package Unidades;

import java.util.ArrayList;
import java.util.List;

import Acciones.Accion;
import Efectos.Efecto;

public abstract class Personaje implements Combatiente{
	final private String nombre, clase, rango;
	final private int vidaMax, manaMax;
	private int vida, mana;
	private List<Efecto> efectos;
	private Accion accion;
	private List<String> objetos;
	//Constructor
	protected Personaje(String nombre, int vida, int mana, String clase, String rango) {
		this.nombre = nombre;
		this.clase = clase;
		this.rango = rango;
		this.vidaMax = vida;
		this.vida=vida;
		this.manaMax = mana;
		this.mana=mana;
		this.efectos = new ArrayList<Efecto>(); 
	}
	
	public void recibirDaño(int daño) {
		this.vida -= daño;
	}
	
	public void gastarMana(int mana) {
		this.mana -= mana;
	}
	
	public boolean puedePelear() {
		if(estaMuerto())	///implementar otras funciones 
			return false;
		return true;
	}
	public boolean tieneEfecto(Class<? extends Efecto> tipoEfecto) {
        for (Efecto efecto : efectos) {
            if (tipoEfecto.isInstance(efecto)) {
                return true;
            }
        }
        return false;
    }
 

	void agregarEfecto(Efecto e){
		efectos.add(e);
	}
	
	void removerEfectos(){
        if(efectos.size()<=0) {
            System.out.println("no hay efectos en este personaje");
            return;
        }
        int i=0;
        while(i<efectos.size()){
            Efecto e=efectos.get(i);
            if(!e.hayTurno()) {
                efectos.remove(i);
                i--;
            }
            i++;
        }
    }
	
	public void bajarTurnosEfectos() {
        for(Efecto e:efectos)
            e.bajarTurno();
    }

	public void activarEfectos(){
		for(Efecto e:efectos)
			e.activar();
	}
	
	@Override
	public void luchar(Combatiente enemigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaMuerto() {
		return this.vida <= 0;
	}

	@Override
	public void getInfo() {
		System.out.println(nombre+"-HP:"+vida+"-M:"+mana+"-"+clase+"-"+rango);
	}
	
	protected abstract void pensarAccion(Batallon aliados, Batallon oponentes);
	
	public void ejecutarAccion() {
		this.accion.ejecutar();
	}

	public void accionar(Batallon aliados, Batallon oponentes) {
		pensarAccion(aliados,oponentes);
		accion.ejecutar();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public Accion getAccion() {
		return accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}
	@Override
	public String toString() {

		return nombre;
	}
	
	
	
	
	
	
}
