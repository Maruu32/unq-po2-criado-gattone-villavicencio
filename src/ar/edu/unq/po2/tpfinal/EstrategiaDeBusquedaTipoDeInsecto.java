package ar.edu.unq.po2.tpfinal;

import java.util.HashSet;
import java.util.stream.Collectors;

public class EstrategiaDeBusquedaTipoDeInsecto implements EstrategiaDeBusqueda {
	
	protected EspecieVinchuca especieBuscada; 
	
	/**
	 * @author Lenardo Criado
	 * 
	 * Esta clase implementa la estrategia de busqueda por tipo de insecto sobre un set de muestras
	 * 
	 * @return
	 */
	protected EspecieVinchuca getEspecieBuscada() {
		return especieBuscada;
	}

	protected void setEspecieBuscada(EspecieVinchuca especieBuscada) {
		this.especieBuscada = especieBuscada;
	}

	public EstrategiaDeBusquedaTipoDeInsecto(EspecieVinchuca especieBuscada) {
		this.setEspecieBuscada(especieBuscada);
	}

	@Override
	public HashSet<Muestra> buscar(HashSet<Muestra> muestrasSet) {
		/**
		 * Filtra el set segun la especie buscada
		 */
		return (HashSet<Muestra>) muestrasSet
				.stream()
				.filter(muestra -> especieBuscada.equals(muestra.getTipo()))
				.collect(Collectors.toSet());
	}

}
