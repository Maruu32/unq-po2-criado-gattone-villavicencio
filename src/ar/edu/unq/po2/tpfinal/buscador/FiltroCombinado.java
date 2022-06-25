package ar.edu.unq.po2.tpfinal.buscador;



import java.util.List;

import ar.edu.unq.po2.tpfinal.Muestra;

public abstract class FiltroCombinado implements Filtro {
	
	/**
	 * @author Lenardo Criado
	 * 
	 * Esta clase modela el compartamiento de un operador lógico que relaciona  2 estrategias de busqueda
	 * 
	 */
	
	protected Filtro estrategia2;
	protected Filtro estrategia1;

	public FiltroCombinado(Filtro estrategia1, Filtro estrategia2) {
		this.setEstrategia1(estrategia1);
		this.setEstrategia2(estrategia2);
	}

	//Setters
	private void setEstrategia2(Filtro estrategia2) {
		this.estrategia2 = estrategia2;
	}
	private void setEstrategia1(Filtro estrategia1) {
		this.estrategia1 = estrategia1;
	}
	
	//Get
	public Filtro getEstrategia2() {
		return estrategia2;
	}
	public Filtro getEstrategia1() {
		return estrategia1;
	}

	@Override
	public abstract List<Muestra> buscar(List<Muestra> muestrasSet) ;



}
