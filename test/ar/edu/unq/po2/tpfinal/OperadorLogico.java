package ar.edu.unq.po2.tpfinal;

import java.util.HashSet;

public abstract class OperadorLogico implements BuscarPor {
	
	/**
	 * @author Lenardo Criado
	 * 
	 * Esta clase modela el compartamiento de un operador lógico que relaciona  2 estrategias de busqueda
	 * 
	 */
	
	protected BuscarPor estrategia2;
	protected BuscarPor estrategia1;

	public OperadorLogico(BuscarPor estrategia1, BuscarPor estrategia2) {
		this.setEstrategia1(estrategia1);
		this.setEstrategia2(estrategia2);
	}

	//Setters
	private void setEstrategia2(BuscarPor estrategia2) {
		this.estrategia2 = estrategia2;
	}
	private void setEstrategia1(BuscarPor estrategia1) {
		this.estrategia1 = estrategia1;
	}
	
	//Get
	public BuscarPor getEstrategia2() {
		return estrategia2;
	}
	public BuscarPor getEstrategia1() {
		return estrategia1;
	}

	@Override
	public abstract HashSet<Muestra> buscar(HashSet<Muestra> muestrasSet) ;



}
