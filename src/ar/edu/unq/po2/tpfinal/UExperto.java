package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

public class UExperto implements EstadoUsuario  {

	private Muestra muestra;
	private Usuario usuario;
	
	public UExperto(Usuario _usuario) {
		usuario = _usuario;
	}

	@Override
	public void opinar(Usuario usuario) {
		
		AplicacionWeb.agregarOpinion(new Opinion(usuario, muestra, this, LocalDate.now()));
	}


}