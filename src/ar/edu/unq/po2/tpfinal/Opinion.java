package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

import ar.edu.unq.po2.tpfinal.persona.EstadoUsuario;
import ar.edu.unq.po2.tpfinal.persona.Usuario;

public class Opinion {
	private Muestra muestra;
	private LocalDate fechaCreacion;
	private Usuario usuario; 
	private ClasificacionMuestra tipo;
	private EstadoUsuario eUsuario;
	
	public Opinion(Usuario usr, Muestra m, ClasificacionMuestra _tipo) {
			usuario = usr;
			muestra = m;
			tipo = _tipo;
			eUsuario = usuario.getEstadoUsuario();
			fechaCreacion = LocalDate.now();
	}
	
	private void setUsuario(Usuario usr) {
		this.usuario = usr;
	}
	
	public Usuario getUsuario() {
		return this.usuario;

	}
	
	private void setOpinion(ClasificacionMuestra t) {
		this.tipo = t;
	}

	public ClasificacionMuestra getTipoMuestra() {
		return this.tipo;
	}

	public LocalDate getFechaCreacion() {
		return this.fechaCreacion;
	}

	public Muestra getMuestra() {
		return muestra;
	}

	public EstadoUsuario geteUsuario() {
		return eUsuario;
	}
}
