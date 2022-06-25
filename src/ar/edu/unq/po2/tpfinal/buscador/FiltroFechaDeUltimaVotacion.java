package ar.edu.unq.po2.tpfinal.buscador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpfinal.Muestra;
import ar.edu.unq.po2.tpfinal.operadorrelacional.OperadorRelacionalFechas;

public class FiltroFechaDeUltimaVotacion extends FiltroFecha {
	
	/**
	 * @author Lenardo Criado
	 * 
	 * Esta clase modela una busqueda por fecha de ultimaVotacion sobre un set de muestras.
	 * 
	 * @param operador configura el tipo de Operador relacional que se va a aplicar (=, >, <, >=, <=)
	 * @param fecha es la fecha buscada
	 */

	public FiltroFechaDeUltimaVotacion(OperadorRelacionalFechas operador, LocalDate fecha) {
		super(operador, fecha);
	}

	@Override
	public List<Muestra> buscar(List<Muestra> muestrasSet) {//TODO: refactor template method
		OperadorRelacionalFechas operador = this.getOperadorRelacional();
		return muestrasSet
				.stream()
				.filter(muestra -> operador.evaluar(muestra.getUltimaFechaOpinion(), this.getFechaBuscada()))
				.collect(Collectors.toList());
	}


}
