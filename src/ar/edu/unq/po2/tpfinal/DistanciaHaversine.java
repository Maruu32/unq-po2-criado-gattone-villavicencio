package ar.edu.unq.po2.tpfinal;

public class DistanciaHaversine implements ICalculadorDistancia {
	
	/*
	 * Se utiliza el algoritmo Haversine para el cálculo de distancias.
	 * 
	 * @author Leonardo Criado
	 */

	@Override
	public double distanciaEnKm(double lon1, double lat1, double lon2, double lat2) {
		double earthRadius = 6371; // km
		double lat1r = Math.toRadians(lat1);
		double lon1r = Math.toRadians(lon1);
		double lat2r = Math.toRadians(lat2);
		double lon2r = Math.toRadians(lon2);
		double dlon = (lon2r - lon1r);
		double dlat = (lat2r - lat1r);
		double sinlat = Math.sin(dlat / 2);
		double sinlon = Math.sin(dlon / 2);
		double a = (sinlat * sinlat) + Math.cos(lat1r)*Math.cos(lat2r)*(sinlon*sinlon);
		double c = 2 * Math.asin (Math.min(1.0, Math.sqrt(a)));
		double distanceInKm = earthRadius * c ;
		return distanceInKm;

		}


}

