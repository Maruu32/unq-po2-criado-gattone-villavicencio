package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.util.HashSet;

public abstract class  EstrategiaDeBusquedaPorFecha {
	
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

	public EstrategiaDeBusquedaPorFecha(OperadorRelacionalFechas operador, LocalDate fecha) {
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
	
	public abstract HashSet<Muestra> buscar(HashSet<Muestra> muestrasSet);

}