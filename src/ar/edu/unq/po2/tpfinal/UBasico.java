package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.time.LocalDate;

public class UBasico implements EstadoUsuario  {
	
	private Muestra muestra;
	private Usuario usuario;

	@Override
	public void opinar(Usuario usuario) {
		if (puedeOpiniar(muestra)) {
			 ((Muestra) muestra.getOpiniones()).add(new Opinion(usuario, muestra, this, LocalDate.now()));
			
		}
		
	}
	
	public boolean puedeOpiniar(Muestra muestra) {
		return  true;
	}


}
