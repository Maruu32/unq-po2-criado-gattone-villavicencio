package ar.edu.unq.po2.tpfinal.muestra;

public class ValidacionMuestraBasica implements ValidacionMuestra{
	
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
}
