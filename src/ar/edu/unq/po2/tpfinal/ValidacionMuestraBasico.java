package ar.edu.unq.po2.tpfinal;

import java.time.LocalDate;
import java.util.List;

public class ValidacionMuestraBasico implements MuestraState{
	
	@Override
	public ClasificacionMuestra getMuestraValidadaActual(Muestra m) {
		return m.getTipoGanadorActual(m.getOpinionesBasicos());
	}

	@Override
	public Boolean usrBasicoPuedeOpinar(Muestra aMuestra){
		return true;
	}

	@Override
	public Boolean usrExpertoPuedeOpinar(Muestra aMuestra){
		return true;
	}

	@Override
	public Boolean esMuestraVerificada(Muestra aMuestra){
		return false;
	}
	
	@Override
	public LocalDate getUltimaOpinion(Muestra aSample) {
		List <Opinion> reviews = aSample.getOpinionesBasicos();
		return reviews.get(reviews.size() - 1).getFechaCreacion();
	}
}
