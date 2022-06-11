package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstrategiaDeBusquedaNivelDeVerificacionTestCase {
	
	EstrategiaDeBusquedaNivelDeVerificacion eTipoDeinsecto;	//SUT
	HashSet<Muestra> muestras;			//DOC
	Muestra muestra0;	//DOC
	Muestra muestra1;	//DOC
	Muestra muestra2;	//DOC

	@BeforeEach
	void setUp() throws Exception {
		eTipoDeinsecto = new EstrategiaDeBusquedaNivelDeVerificacion(NivelVerificacion.VOTADA);
		muestras = new HashSet<Muestra>();
		muestra0 = mock(Muestra.class);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
	}

	@Test
	void testUnaMuestraEncontrada() {
		//Setup
		muestras.add(muestra0);
		muestras.add(muestra1);
		muestras.add(muestra2);
		when(muestra0.estaVerificada()).thenReturn(false);
		when(muestra1.estaVerificada()).thenReturn(true);
		when(muestra2.estaVerificada()).thenReturn(true);
		HashSet<Muestra> resultadoEsperado = new HashSet<Muestra>();
		resultadoEsperado.add(muestra0);
				
		//Excersice
		HashSet<Muestra> resultadoBusqueda = eTipoDeinsecto.buscar(muestras);
		
		//Verify
		assertEquals(true, resultadoBusqueda.containsAll(resultadoEsperado));
		assertEquals(1, resultadoBusqueda.size());
		verify(muestra0, times(1)).estaVerificada();
		verify(muestra1, times(1)).estaVerificada();
		verify(muestra2, times(1)).estaVerificada();
	}
	
	@Test
	void testNingunaMuestraEncontrada() {
		//Setup
		muestras.add(muestra0);
		muestras.add(muestra1);
		muestras.add(muestra2);
		when(muestra0.estaVerificada()).thenReturn(true);
		when(muestra1.estaVerificada()).thenReturn(true);
		when(muestra2.estaVerificada()).thenReturn(true);
		HashSet<Muestra> resultadoEsperado = new HashSet<Muestra>();
		resultadoEsperado.add(muestra0);
				
		//Excersice
		HashSet<Muestra> resultadoBusqueda = eTipoDeinsecto.buscar(muestras);
		
		//Verify
		assertEquals(true, resultadoBusqueda.isEmpty());
		verify(muestra0, times(1)).estaVerificada();
		verify(muestra1, times(1)).estaVerificada();
		verify(muestra2, times(1)).estaVerificada();
	}

}
