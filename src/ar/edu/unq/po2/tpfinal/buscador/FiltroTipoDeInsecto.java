package ar.edu.unq.po2.tpfinal.buscador;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpfinal.muestra.EspecieVinchuca;
import ar.edu.unq.po2.tpfinal.muestra.Muestra;

public class FiltroTipoDeInsecto implements Filtro {
	
	protected EspecieVinchuca especieBuscada; 

	
	/**
	 * @author Lenardo Criado
	 * 
	 * Esta clase implementa la estrategia de busqueda por tipo de insecto sobre un set de muestras
	 * 
	 * @return
	 */


	protected void setEspecieBuscada(EspecieVinchuca especieBuscada) {
		this.especieBuscada = especieBuscada;
	}

	public FiltroTipoDeInsecto(EspecieVinchuca especieBuscada) {
		this.setEspecieBuscada(especieBuscada);
	}

	@Override
	public List<Muestra> buscar(List<Muestra> muestrasSet) {
		/**
		 * Filtra el set segun la especie buscada
		 */
		return muestrasSet
				.stream()
				.filter(muestra -> especieBuscada.equals(muestra.getTipo()))
				.collect(Collectors.toList());
	}

}
