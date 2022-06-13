package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.util.Date;


public class Opinion {
	private LocalDate fechaCreacion = LocalDate.now();
	private Usuario usr;
	private ClasificacionMuestra tipo;
	
	public Opinion(Usuario usr, ClasificacionMuestra tipo) {
		this.setUsuario(usr);
		this.setOpinion(tipo);
	}
	
	private void setUsuario(Usuario usr) {
		this.usr = usr;
	}
	
	public Usuario getUsuario() {
		return this.usr;
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
}
