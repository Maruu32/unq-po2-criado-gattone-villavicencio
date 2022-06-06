package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

public class UExperto implements EstadoUsuario  {

	private Muestra muestra;
	private Usuario usuario;
	
	@Override
	public void opinar(Usuario usuario) {
		
		((Muestra) muestra.getOpiniones()).add(new Opinion(usuario, muestra, this, LocalDate.now()));
	}


}