package ar.edu.unq.po2.tpfinal.muestra;

public enum NoEsVinchuca implements ClasificacionMuestra{
	CHINCHE_FOLIADA,
	PHTIA_CHINCHE,
	NINGUNA,
	IMAGEN_POCO_CLARA;
	
	public boolean esVinchuca() {
		return false;
	}

}
