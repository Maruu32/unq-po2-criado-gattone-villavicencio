package ar.edu.unq.po2.tpfinal;

import java.util.HashSet;

public class And extends OperadorLogico {

	public And(EstrategiaDeBusqueda estrategia1, EstrategiaDeBusqueda estrategia2) {
		super(estrategia1, estrategia2);

	}

	@Override
	public HashSet<Muestra> buscar(HashSet<Muestra> muestrasSet) {
		HashSet<Muestra> resultado1 = estrategia1.buscar(muestrasSet); 	//Aplica la primer estrategia
		resultado1.retainAll(estrategia2.buscar(muestrasSet));			//Me quedo con la interseccion de aplicar la segunda estrategia a al mismo set de muestras
		return resultado1;
	}

}
