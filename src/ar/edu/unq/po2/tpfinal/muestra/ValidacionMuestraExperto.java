package ar.edu.unq.po2.tpfinal.muestra;

import java.time.LocalDate;
import java.util.List;

public class ValidacionMuestraExperto implements MuestraState{
	@Override
	public ClasificacionMuestra getMuestraValidadaActual(Muestra m) {
		return m.getTipoGanadorActual(m.getOpinionesExpertos());

	}
	
	@Override
	public Boolean usrBasicoPuedeOpinar(Muestra m) {
		return false;
	}
	
	@Override
	public Boolean usrExpertoPuedeOpinar(Muestra m) {
		return this.esMuestraVerificada(m);
	}
	
	@Override
	public Boolean esMuestraVerificada(Muestra m) {
		return EspecieNoDefinida.UNDEFINED != m.getMuestraValidadaActual() && m.getOpinionesExpertos().size() == 2;
	}

	@Override
	public LocalDate getUltimaOpinion(Muestra aSample) {
		List <Opinion> reviews = aSample.getOpinionesExpertos();
		return reviews.get(reviews.size() - 1).getFechaCreacion();
	}

}
