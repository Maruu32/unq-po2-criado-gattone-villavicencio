package ar.edu.unq.po2.tpfinal.muestra;

public interface ValidacionMuestra {
	public ClasificacionMuestra getMuestraValidadaActual(Muestra aMuestra);
	public Boolean usrBasicoPuedeOpinar(Muestra aMuestra);
	public Boolean usrExpertoPuedeOpinar(Muestra aMuestra);
	public Boolean esMuestraVerificada(Muestra aMuestra);
}
