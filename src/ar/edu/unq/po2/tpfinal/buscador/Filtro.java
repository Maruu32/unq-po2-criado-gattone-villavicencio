package ar.edu.unq.po2.tpfinal.buscador;

import java.util.List;

import ar.edu.unq.po2.tpfinal.muestra.Muestra;

public interface Filtro {

	List<Muestra> buscar(List<Muestra> muestrasSet);

}
