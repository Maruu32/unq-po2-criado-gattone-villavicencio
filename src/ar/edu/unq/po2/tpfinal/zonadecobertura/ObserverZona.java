package ar.edu.unq.po2.tpfinal.zonadecobertura;

import ar.edu.unq.po2.tpfinal.Muestra;

public interface ObserverZona {
	/**
	 * @author Lenardo Criado
	 * @param zonaDeCobertura
	 * @param muestra1
	 * @param tipoAviso
	 */
	void update(ZonaDeCobertura zonaDeCobertura, Muestra muestra1, TipoAvisoZona tipoAviso);

}
