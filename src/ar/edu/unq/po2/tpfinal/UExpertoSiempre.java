package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

public class UExpertoSiempre implements EstadoUsuario  {
	
	private Muestra muestra;
	private Usuario usuario;

	@Override
	public void opinar(Usuario usuario) {
		if (puedeOpinar()) {
		((Muestra) muestra.getOpiniones()).add(new Opinion(usuario, muestra, this, LocalDate.now()));
		}
	}

	private boolean puedeOpinar() {
		return false;
	}



	
}
