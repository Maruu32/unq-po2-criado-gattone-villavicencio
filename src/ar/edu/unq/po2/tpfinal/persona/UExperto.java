package ar.edu.unq.po2.tpfinal.persona;

import java.time.LocalDate;

import ar.edu.unq.po2.tpfinal.muestra.ClasificacionMuestra;
import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.muestra.Opinion;

public class UExperto implements EstadoUsuario  {

	
	public UExperto() { 
	}

	@Override 
	public void opinar(ClasificacionMuestra clasificacion, Usuario _usuario, Muestra muestra) { 
		//si puede opinar crea un opinion 
	  if(!puedeOpinar(muestra)){
		  muestra.agregarOpinion(new Opinion(_usuario, muestra, clasificacion));
	  }  
	}
	@Override
	public boolean puedeOpinar(Muestra muestra) {
		// TODO Auto-generated method stub
		return muestra.estaVerificada();
	}

}