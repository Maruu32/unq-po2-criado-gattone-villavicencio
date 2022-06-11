package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.stream.Collectors;

public class EstrategiaDeBusquedaPorFechaDeCreacion extends EstrategiaDeBusquedaPorFecha implements EstrategiaDeBusqueda {
	/**
	 * @author Lenardo Criado
	 * 
	 * Esta clase modela una busqueda por fecha de creacion sobre un set de muestras.
	 * 
	 * @param operador configura el tipo de Operador relacional que se va a aplicar (=, >, <, >=, <=)
	 * @param fecha es la fecha buscada
	 */

	public EstrategiaDeBusquedaPorFechaDeCreacion(OperadorRelacional operador, LocalDate fecha) {
		super(operador,fecha);
	}	
	

	@Override
	public HashSet<Muestra> buscar(HashSet<Muestra> muestrasSet) {
		OperadorRelacional operador = this.getOperadorRelacional();
		return (HashSet<Muestra>) muestrasSet
				.stream()
				.filter(muestra -> operador.evaluar(muestra.getFechaCreacion(), this.getFechaBuscada()))
				.collect(Collectors.toSet());
	}

}
