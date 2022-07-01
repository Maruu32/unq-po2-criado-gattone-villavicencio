package ar.edu.unq.po2.tpfinal.persona;

import ar.edu.unq.po2.tpfinal.ClasificacionMuestra;
import ar.edu.unq.po2.tpfinal.Muestra;

public interface EstadoUsuario {

	void opinar(ClasificacionMuestra clasificacion, Usuario uusuario, Muestra muestra);
	boolean puedeOpinar(Muestra muestra);


}
