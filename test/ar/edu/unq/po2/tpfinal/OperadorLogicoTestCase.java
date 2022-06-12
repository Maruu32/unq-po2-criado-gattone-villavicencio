package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperadorLogicoTestCase {
	
	OperadorLogico or;			//SUT
	OperadorLogico and;			//SUT
	EstrategiaDeBusqueda estrategia1;	//DOC
	EstrategiaDeBusqueda estrategia2;	//DOC
	EstrategiaDeBusqueda estrategia3;	//DOC
	HashSet<Muestra> muestras;			//DOC
	HashSet<Muestra> muestras1;			//DOC
	HashSet<Muestra> muestras2;			//DOC
	HashSet<Muestra> muestras3;			//DOC
	Muestra muestra0;	//DOC
	Muestra muestra1;	//DOC
	Muestra muestra2;	//DOC
	Muestra muestra3;	//DOC
	Muestra muestra4;	//DOC
	Muestra muestra5;	//DOC

	@BeforeEach
	void setUp() throws Exception {
		estrategia1 = mock(EstrategiaDeBusqueda.class);
		estrategia2 = mock(EstrategiaDeBusqueda.class);
		estrategia3 = mock(EstrategiaDeBusqueda.class);
		muestras = new HashSet<Muestra>();
		muestras1 = new HashSet<Muestra>();
		muestras2 = new HashSet<Muestra>();
		muestras3 = new HashSet<Muestra>();
		muestra0 = mock(Muestra.class);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);
		muestra5 = mock(Muestra.class);
		Collections.addAll(muestras1, muestra0, muestra1, muestra2);
		Collections.addAll(muestras2, muestra3, muestra4);
		Collections.addAll(muestras3, muestra1, muestra4, muestra0);
		or = new Or(estrategia1, estrategia2);
		and = new And(estrategia1, estrategia2);
		
	}

	@Test
	void testOr() {
		//setup
		when(estrategia1.buscar(muestras)).thenReturn(muestras1);
		when(estrategia2.buscar(muestras)).thenReturn(muestras2);
		HashSet<Muestra> resultadoEsperado =  new HashSet<Muestra>(); 
		Collections.addAll(resultadoEsperado, muestra0, muestra1, muestra2, muestra3, muestra4);
		
		//excercise
		HashSet<Muestra> resultado = or.buscar(muestras);
		
		//verify
		assertEquals(resultadoEsperado, resultado);
		assertEquals(5, resultado.size());
		verify(estrategia1, times(1)).buscar(muestras);
		verify(estrategia2, times(1)).buscar(muestras);
	}
	
	@Test
	void testAnd() {
		//setup
		when(estrategia1.buscar(muestras)).thenReturn(muestras1);
		when(estrategia2.buscar(muestras)).thenReturn(muestras3);
		HashSet<Muestra> resultadoEsperado =  new HashSet<Muestra>(); 
		Collections.addAll(resultadoEsperado, muestra0, muestra1);
		
		//excercise
		HashSet<Muestra> resultado = and.buscar(muestras);
		
		//verify
		assertEquals(resultadoEsperado, resultado);
		assertEquals(2, resultado.size());
		verify(estrategia1, times(1)).buscar(muestras);
		verify(estrategia2, times(1)).buscar(muestras);
	}
	

}
