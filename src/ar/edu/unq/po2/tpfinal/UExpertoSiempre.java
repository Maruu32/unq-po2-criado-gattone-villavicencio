package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

public class UExpertoSiempre implements EstadoUsuario  {
	
	private Muestra muestra;
	private Usuario usuario;

	@Override
	public void opinar(ClasificacionMuestra clasificacion) {
		if (puedeOpinar()) {
			AplicacionWeb.agregarOpinion(new Opinion(usuario, muestra, this, clasificacion));  
		}
		
	}
	
	

	private boolean puedeOpinar() {
		return true;
	}



	
}
