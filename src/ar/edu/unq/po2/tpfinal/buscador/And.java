package ar.edu.unq.po2.tpfinal.buscador;

import java.util.List;

import ar.edu.unq.po2.tpfinal.muestra.Muestra;

public class And extends FiltroCombinado {

	public And(Filtro estrategia1, Filtro estrategia2) {
		super(estrategia1, estrategia2);

	}

	@Override
	public List<Muestra> buscar(List<Muestra> muestrasSet) {
		List<Muestra> resultado1 = estrategia1.buscar(muestrasSet); 	//Aplica la primer estrategia
		resultado1.retainAll(estrategia2.buscar(muestrasSet));			//Me quedo con la interseccion de aplicar la segunda estrategia a al mismo set de muestras
		return resultado1;
	}

}
