package Unidades;

import java.util.ArrayList;
import java.util.List;

import Acciones.Accion;
import Efectos.Efecto;
import Hechizos.*;

public abstract class Personaje implements Combatiente{
	final protected String nombre, clase, rango;
	final protected int vidaMax, manaMax;
	protected int vida, mana;
	protected List<Efecto> efectos;
	protected Accion accion;
	protected List<String> consumibles;
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
		this.consumibles = new ArrayList<String>();
	}
	
	public void recibirDaño(int daño) {
		this.vida -= daño;
	}
	
	public void ganarVida(int vida){
		this.vida+=vida;
		if(this.vida>vidaMax)
			this.vida=vidaMax;
	}
	
	public void gastarMana(int mana) {
		this.mana -= mana;
	}
	
	public void ganarMana(int mana) {
		this.mana+=mana;
		if(this.mana>manaMax)
			this.mana=manaMax;
	}
	
	public boolean puedePelear() {
		if(estaMuerto())	///implementar otras funciones 
			return false;
		return true;
	}
	
	public boolean tienePocaVida() {
		return ((int)vidaMax*0.2)>=vida;
	}
	
	public boolean tienePocoMana() {
		return ((int)manaMax*0.2)>=mana;
	}
	
	public boolean tieneEfecto(Class<? extends Efecto> tipoEfecto) {
        for (Efecto efecto : efectos) {
            if (tipoEfecto.isInstance(efecto)) {
                return true;
            }
        }
        return false;
    }
	
	public boolean tieneConsumible(String objeto) {
		for(String objetoActual:consumibles)
			if(objetoActual.equalsIgnoreCase(objeto))	///modificar despúes si es asi
				return true;
		return false;
	}
	

	public boolean tieneSuficenteMagia(String nombreHechizo) {
		///aca se preguntaria a prolog 
		if(nombreHechizo.equals("AvadaKedavra"))
			if(mana>=AvadaKedavra.costo)
				return true;
		
		if(nombreHechizo.equals("Septusembra"))
			if(mana>=Septusembra.costo)
				return true;
		
		if(nombreHechizo.equals("Bombardum"))
			if(mana>=Bombardum.costo)
				return true;
		
		if(nombreHechizo.equals("Protego"))
			if(mana>=Protego.costo)
				return true;
		if(nombreHechizo.equals("Veneficus"))
			if(mana>=Veneficus.costo)
				return true;
		if(nombreHechizo.equals("Incendium"))
			if(mana>=Incendium.costo)
				return true;
		
		if(nombreHechizo.equals("Petrificus"))
			if(mana>=Petrificus.costo)
				return true;
		
		return false;
	}
	
	public String obtenerPrimerNombreObjetoUtil() {
		String nombreConsumible=null;
			
		for(String consumible:consumibles)
			if(esUtil(consumible))
				return consumible;
		return nombreConsumible;
	}

	private boolean esUtil(String consumible) {
		if( consumible.equalsIgnoreCase("pocionVida") ) 
			if(this.tienePocaVida())
				return true;
		
		if( consumible.equalsIgnoreCase("pocionMana") ) 
			if(this.tienePocaEnergia())
				return true;
		
		return false;
	}

	private boolean tienePocaEnergia() {
		// TODO Auto-generated method stub
		return false;
	}

	public void agregarEfecto(Efecto e){
		efectos.add(e);
	}
	
	public void removerEfectos(){
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
	}

	@Override
	public boolean estaMuerto() {
		return this.vida <= 0;
	}

	@Override
	public void getInfo() {
		System.out.printf("%-20s  HP:%3d/%3d EM:%3d/%3d   %s-%s \n",
				nombre,vida,vidaMax,mana,manaMax,clase,rango);
		//System.out.println(nombre+"-HP:"+vida+"/"+vidaMax+"-M:"+mana+"/"+manaMax+"-"+clase+"-"+rango);
	}
	
	public abstract void pensarAccion(Batallon aliados, Batallon oponentes);
	
	public void ejecutarAccion() {
		this.accion.ejecutar();
	}

	public void accionar(Batallon aliados, Batallon oponentes) {
		pensarAccion(aliados,oponentes);
		accion.ejecutar();
	}

	public void quitarDeListaDeObjetos(String nombreObjeto) {
		consumibles.remove(nombreObjeto);
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
