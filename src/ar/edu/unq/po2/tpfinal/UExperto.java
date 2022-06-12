package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

public class UExperto implements EstadoUsuario  {

	private Muestra muestra;
	private Usuario usuario;
	
	public UExperto(Usuario _usuario) { 
		usuario = _usuario; 
	}

	@Override
	public void opinar(ClasificacionMuestra clasificacion) {
		//si puede opinar crea un opinion 
	  if(true){
		  	AplicacionWeb.agregarOpinion(new Opinion(usuario, muestra, this, clasificacion));
	  }
	}

}