package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroFechaDeCreacion extends FiltroFecha implements Filtro {
	/**
	 * @author Lenardo Criado
	 * 
	 * Esta clase modela una busqueda por fecha de creacion sobre un set de muestras.
	 * 
	 * @param operador configura el tipo de Operador relacional que se va a aplicar (=, >, <, >=, <=)
	 * @param fecha es la fecha buscada
	 */

	public FiltroFechaDeCreacion(OperadorRelacionalFechas operador, LocalDate fecha) {
		super(operador,fecha);
	}	
	

	@Override
	public List<Muestra> buscar(List<Muestra> muestrasSet) {
		OperadorRelacionalFechas operador = this.getOperadorRelacional();
		return muestrasSet
				.stream()
				.filter(muestra -> operador.evaluar(muestra.getFechaCreacion(), this.getFechaBuscada()))
				.collect(Collectors.toList());
	}

}