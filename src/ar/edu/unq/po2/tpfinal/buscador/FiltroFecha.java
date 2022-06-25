package ar.edu.unq.po2.tpfinal.buscador;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unq.po2.tpfinal.Muestra;
import ar.edu.unq.po2.tpfinal.operadorrelacional.OperadorRelacionalFechas;

public abstract class  FiltroFecha {
	
	/**
	 * @author Lenardo Criado
	 * 
	 * Esta clase modela una busqueda por fecha sobre un set de muestras.
	 * 
	 * @param operador configura el tipo de Operador relacional que se va a aplicar (=, >, <, >=, <=)
	 * @param fecha es la fecha buscada.
	 */

	private LocalDate fechaBuscada;
	private OperadorRelacionalFechas operadorRelacional;

	public FiltroFecha(OperadorRelacionalFechas operador, LocalDate fecha) {
		this.setOperadorRelacional(operador);
		this.setFechaBuscada(fecha);
	}

	protected void setFechaBuscada(LocalDate fecha) {
		this.fechaBuscada = fecha;	
	}

	protected void setOperadorRelacional(OperadorRelacionalFechas operador) {
		this.operadorRelacional = operador;
	}

	protected LocalDate getFechaBuscada() {
		return fechaBuscada;
	}

	protected OperadorRelacionalFechas getOperadorRelacional() {
		return operadorRelacional;
	}
	
	public abstract List<Muestra> buscar(List<Muestra> muestrasSet);

}