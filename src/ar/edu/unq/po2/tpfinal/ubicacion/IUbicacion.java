package ar.edu.unq.po2.tpfinal.ubicacion;

import java.util.List;

public interface IUbicacion {
	
	public double distanciaEnKm(Ubicacion ubicacion1);
	public List<Ubicacion> ubicacionesAMenosDe(double distancia, List<Ubicacion> ubicaciones);
	
}
