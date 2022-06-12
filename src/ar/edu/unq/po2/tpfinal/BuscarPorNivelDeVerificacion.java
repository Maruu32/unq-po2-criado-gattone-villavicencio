package ar.edu.unq.po2.tpfinal;

import java.util.HashSet;
import java.util.stream.Collectors;

public class BuscarPorNivelDeVerificacion implements BuscarPor {
	
	protected NivelVerificacion nivelDeVerificacion;
	
	/**
	 * @author Lenardo Criado
	 * 
	 * Esta clase implementa la estrategia de busqueda por estado de validacion de las muestras
	 * 
	 * @return
	 */

	protected void setNivelDeVerificacion(NivelVerificacion nivelDeVerificacion) {
		this.nivelDeVerificacion = nivelDeVerificacion;
	}

	public BuscarPorNivelDeVerificacion(NivelVerificacion votada) {
		this.setNivelDeVerificacion(votada);
	}

	public HashSet<Muestra> buscar(HashSet<Muestra> muestras) {
		/**
		 * Filtra el set segun el estado de la muestra
		 */
		return (HashSet<Muestra>) muestras
				.stream()
				.filter(muestra -> nivelDeVerificacion.value() == muestra.estaVerificada())
				.collect(Collectors.toSet());
	}

}
