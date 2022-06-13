package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;

public interface MuestraState {
	public ClasificacionMuestra getMuestraValidadaActual(Muestra aMuestra);
	public Boolean usrBasicoPuedeOpinar(Muestra aMuestra);
	public Boolean usrExpertoPuedeOpinar(Muestra aMuestra);
	public Boolean esMuestraVerificada(Muestra aMuestra);
	public LocalDate getUltimaOpinion(Muestra aSample);
}
