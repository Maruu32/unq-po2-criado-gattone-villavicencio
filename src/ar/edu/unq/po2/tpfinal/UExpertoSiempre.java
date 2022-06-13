package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

public class UExpertoSiempre implements EstadoUsuario  {
	
	private Muestra muestra;
	private Usuario usuario;

	@Override
	public void opinar(ClasificacionMuestra clasificacion) {
		if (!puedeOpinar()) {
			 usuario.getAp().agregarOpinion(new Opinion(usuario, muestra, clasificacion));  
		}
		
	}
	
	
	@Override
	public boolean puedeOpinar() {
		return muestra.estaVerificada();
	}



	
}
