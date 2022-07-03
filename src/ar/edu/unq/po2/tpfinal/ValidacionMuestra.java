package ar.edu.unq.po2.tpfinal;

public class ValidacionMuestra{
	
	public ClasificacionMuestra getMuestraValidadaActual(Muestra m) {
		return m.getTipoGanadorActual(m.getOpiniones());
	}

	public Boolean usrBasicoPuedeOpinar(Muestra aMuestra){
		return aMuestra.getUsuario() == "Basico";
	}

	public Boolean usrExpertoPuedeOpinar(Muestra aMuestra){
		return aMuestra.getUsuario() == "Experto";
								 
	}

	public Boolean esMuestraVerificada(Muestra aMuestra){
		aMuestra.getUsuario() == "Basico";
		}
}
