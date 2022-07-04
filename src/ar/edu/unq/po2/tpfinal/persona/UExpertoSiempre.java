package ar.edu.unq.po2.tpfinal.persona;

import java.time.LocalDate;

import ar.edu.unq.po2.tpfinal.muestra.ClasificacionMuestra;
import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.muestra.Opinion;

public class UExpertoSiempre implements EstadoUsuario  {
	
	
	public UExpertoSiempre() { 

	}

	@Override
	public void opinar(ClasificacionMuestra clasificacion, Usuario usuario, Muestra muestra) { 
		if (!puedeOpinar(muestra)) {
			muestra.agregarOpinion(new Opinion(usuario, muestra, clasificacion)); 
		}
	}
	
	
	@Override
	public boolean puedeOpinar(Muestra muestra) {
		return muestra.estaVerificada();
	}



	
}