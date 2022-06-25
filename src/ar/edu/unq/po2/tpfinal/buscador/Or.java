package ar.edu.unq.po2.tpfinal.buscador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import ar.edu.unq.po2.tpfinal.Muestra;

public class Or extends FiltroCombinado {

	public Or(Filtro estrategia1, Filtro estrategia2) {
		super(estrategia1, estrategia2);
	}

	@Override
	public List<Muestra> buscar(List<Muestra> muestras) {
		HashSet<Muestra> resultado = new HashSet<Muestra>();
		resultado.addAll(estrategia1.buscar(muestras));
		resultado.addAll(estrategia2.buscar(muestras));
		return new ArrayList<Muestra>(resultado);
	}

}
