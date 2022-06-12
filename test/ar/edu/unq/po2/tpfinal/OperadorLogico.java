package ar.edu.unq.po2.tpfinal;

import java.util.HashSet;

public abstract class OperadorLogico implements EstrategiaDeBusqueda {
	
	/**
	 * @author Lenardo Criado
	 * 
	 * Esta clase modela el compartamiento de un operador lógico que relaciona  2 estrategias de busqueda
	 * 
	 */
	
	protected EstrategiaDeBusqueda estrategia2;
	protected EstrategiaDeBusqueda estrategia1;

	public OperadorLogico(EstrategiaDeBusqueda estrategia1, EstrategiaDeBusqueda estrategia2) {
		this.setEstrategia1(estrategia1);
		this.setEstrategia2(estrategia2);
	}

	//Setters
	private void setEstrategia2(EstrategiaDeBusqueda estrategia2) {
		this.estrategia2 = estrategia2;
	}
	private void setEstrategia1(EstrategiaDeBusqueda estrategia1) {
		this.estrategia1 = estrategia1;
	}
	
	//Get
	public EstrategiaDeBusqueda getEstrategia2() {
		return estrategia2;
	}
	public EstrategiaDeBusqueda getEstrategia1() {
		return estrategia1;
	}

	@Override
	public abstract HashSet<Muestra> buscar(HashSet<Muestra> muestrasSet) ;



}
