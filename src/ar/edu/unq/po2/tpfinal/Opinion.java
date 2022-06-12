package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

public class Opinion {

	private Usuario usuario;
	private Muestra muestra;
	private EstadoUsuario estado;
	private LocalDate fecha;
	private ClasificacionMuestra clasificacion;
	
	public Opinion (Usuario _usuario, Muestra _muestra, EstadoUsuario _estado, ClasificacionMuestra _clasificacion){ 
		usuario = _usuario;
		muestra = _muestra;
		estado = _estado;
		fecha = LocalDate.now();
		clasificacion =_clasificacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

		
}
