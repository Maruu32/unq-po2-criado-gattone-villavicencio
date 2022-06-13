package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

public class UExperto implements EstadoUsuario  {

	private Muestra muestra;
	private Usuario usuario;
	
	
	public UExperto(Usuario _usuario, Muestra _muestra) { 
		usuario = _usuario; 
		muestra = _muestra;
	}

	@Override
	public void opinar(ClasificacionMuestra clasificacion) {
		//si puede opinar crea un opinion 
	  if(!puedeOpinar()){
		  usuario.getAp().agregarOpinion(new Opinion(usuario, muestra, clasificacion));
	  }
	}
	@Override
	public boolean puedeOpinar() {
		// TODO Auto-generated method stub
		return muestra.estaVerificada();
	}

}