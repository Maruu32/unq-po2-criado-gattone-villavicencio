package ar.edu.unq.po2.tpfinal.buscador;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unq.po2.tpfinal.Muestra;
import ar.edu.unq.po2.tpfinal.NivelVerificacion;

public class FiltroNivelDeVerificacion implements Filtro {
	
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

	public FiltroNivelDeVerificacion(NivelVerificacion votada) {
		this.setNivelDeVerificacion(votada);
	}

	public List<Muestra> buscar(List<Muestra> muestras) {
		/**
		 * Filtra el set segun el estado de la muestra
		 */
		return muestras
				.stream()
				.filter(muestra -> nivelDeVerificacion.value() == muestra.estaVerificada())
				.collect(Collectors.toList());
	}

}
