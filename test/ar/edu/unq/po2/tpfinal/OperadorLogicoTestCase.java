package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperadorLogicoTestCase {
	
	FiltroCombinado or;			//SUT
	FiltroCombinado and;			//SUT
	Filtro estrategia1;	//DOC
	Filtro estrategia2;	//DOC
	Filtro estrategia3;	//DOC
	List<Muestra> muestras;			//DOC
	List<Muestra> muestras1;			//DOC
	List<Muestra> muestras2;			//DOC
	List<Muestra> muestras3;			//DOC
	Muestra muestra0;	//DOC
	Muestra muestra1;	//DOC
	Muestra muestra2;	//DOC
	Muestra muestra3;	//DOC
	Muestra muestra4;	//DOC
	Muestra muestra5;	//DOC

	@BeforeEach
	void setUp() throws Exception {
		estrategia1 = mock(Filtro.class);
		estrategia2 = mock(Filtro.class);
		estrategia3 = mock(Filtro.class);
		muestras = new ArrayList<Muestra>();
		muestras1 = new ArrayList<Muestra>();
		muestras2 = new ArrayList<Muestra>();
		muestras3 = new ArrayList<Muestra>();
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
		List<Muestra> resultadoEsperado =  new ArrayList<Muestra>(); 
		Collections.addAll(resultadoEsperado, muestra0, muestra1, muestra2, muestra3, muestra4);
		
		//excercise
		List<Muestra> resultado = or.buscar(muestras);
		
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
		List<Muestra> resultadoEsperado =  new ArrayList<Muestra>(); 
		Collections.addAll(resultadoEsperado, muestra0, muestra1);
		
		//excercise
		List<Muestra> resultado = and.buscar(muestras);
		
		//verify
		assertEquals(resultadoEsperado, resultado);
		assertEquals(2, resultado.size());
		verify(estrategia1, times(1)).buscar(muestras);
		verify(estrategia2, times(1)).buscar(muestras);
	}
	

}
