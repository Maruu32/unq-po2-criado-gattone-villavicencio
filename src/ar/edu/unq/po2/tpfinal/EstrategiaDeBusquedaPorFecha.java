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
	private OperadorRelacional operadorRelacional;

	public EstrategiaDeBusquedaPorFecha(OperadorRelacional operador, LocalDate fecha) {
		this.setOperadorRelacional(operador);
		this.setFechaBuscada(fecha);
	}

	protected void setFechaBuscada(LocalDate fecha) {
		this.fechaBuscada = fecha;	
	}

	protected void setOperadorRelacional(OperadorRelacional operador) {
		this.operadorRelacional = operador;
	}

	protected LocalDate getFechaBuscada() {
		return fechaBuscada;
	}

	protected OperadorRelacional getOperadorRelacional() {
		return operadorRelacional;
	}
	
	public abstract HashSet<Muestra> buscar(HashSet<Muestra> muestrasSet);

}