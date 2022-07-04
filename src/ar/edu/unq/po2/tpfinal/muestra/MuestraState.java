package ar.edu.unq.po2.tpfinal.muestra;

import java.time.LocalDate;

public interface MuestraState {
	public ClasificacionMuestra getMuestraValidadaActual(Muestra aMuestra);
	public Boolean usrBasicoPuedeOpinar(Muestra aMuestra);
	public Boolean usrExpertoPuedeOpinar(Muestra aMuestra);
	public Boolean esMuestraVerificada(Muestra aMuestra);
	public LocalDate getUltimaOpinion(Muestra aSample);
}
