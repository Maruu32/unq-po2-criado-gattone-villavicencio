package ar.edu.unq.po2.tpfinal;

import java.util.Date;

import ar.edu.unq.po2.tpfinal.ClasificacionMuestra;
import ar.edu.unq.po2.tpfinal.Usuario;


public class Opinion {
	private Date fechaCreacion = new Date();
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
	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}
}
