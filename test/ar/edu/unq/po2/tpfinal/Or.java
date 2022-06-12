package ar.edu.unq.po2.tpfinal;

import java.util.HashSet;

public class Or extends OperadorLogico {

	public Or(BuscarPor estrategia1, BuscarPor estrategia2) {
		super(estrategia1, estrategia2);
	}

	@Override
	public HashSet<Muestra> buscar(HashSet<Muestra> muestrasSet) {
		HashSet<Muestra> resultado = new HashSet<Muestra>();
		resultado.addAll(estrategia1.buscar(muestrasSet));
		resultado.addAll(estrategia2.buscar(muestrasSet));
		return resultado;
	}

}
