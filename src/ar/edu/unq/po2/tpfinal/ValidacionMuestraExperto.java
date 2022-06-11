package ar.edu.unq.po2.tpfinal;

public class ValidacionMuestraExperto implements ValidacionMuestra{
	@Override
	public ClasificacionMuestra getMuestraValidadaActual(Muestra m) {
		return m.getTipoGanadorActual(m.getOpinionesBasicos());
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
}
