package ar.edu.unq.po2.tpfinal.persona;

import ar.edu.unq.po2.tpfinal.muestra.ClasificacionMuestra;
import ar.edu.unq.po2.tpfinal.muestra.Muestra;

public interface EstadoUsuario {

	void opinar(ClasificacionMuestra clasificacion, Usuario uusuario, Muestra muestra);
	boolean puedeOpinar(Muestra muestra);


}
