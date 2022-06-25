package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FiltroFechaDeCreacionTestCase {
	
	FiltroFechaDeCreacion eBusquedaFechaCreacion; //SUT
	List<Muestra> muestras;			//DOC
	Muestra muestra0;	//DOC
	Muestra muestra1;	//DOC
	Muestra muestra2;	//DOC
	OperadorRelacionalFechas operador; //DOC
	LocalDate fecha;

	@BeforeEach
	void setUp() throws Exception {
		muestras = new ArrayList<Muestra>();
		muestra0 = mock(Muestra.class);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		operador = mock(OperadorRelacionalFechas.class);
		fecha = LocalDate.parse("2020-06-09");
		eBusquedaFechaCreacion = new FiltroFechaDeCreacion(operador, fecha);
		muestras.add(muestra0);
		muestras.add(muestra1);
		muestras.add(muestra2);
		when(muestra0.getFechaCreacion()).thenReturn(LocalDate.parse("2020-06-09"));
		when(muestra1.getFechaCreacion()).thenReturn(LocalDate.parse("2020-06-23"));
		when(muestra2.getFechaCreacion()).thenReturn(LocalDate.parse("2020-07-03"));
		
	}

	@Test
	void testFechaIgual() {
		//Setup
		
		List<Muestra> resultadoEsperado = new ArrayList<Muestra>();
		resultadoEsperado.add(muestra0);
		when(operador.evaluar(LocalDate.parse("2020-06-09"), LocalDate.parse("2020-06-09"))).thenReturn(true);
		
		//Excercise
		List<Muestra> resultadoBusqueda = eBusquedaFechaCreacion.buscar(muestras);
		
		
		//Verify
		assertEquals(true, resultadoBusqueda.containsAll(resultadoEsperado));
		assertEquals(1, resultadoBusqueda.size());
		verify(muestra0, times(1)).getFechaCreacion();
		verify(muestra1, times(1)).getFechaCreacion();
		verify(muestra2, times(1)).getFechaCreacion();
		verify(operador, times(1)).evaluar(LocalDate.parse("2020-06-09"), LocalDate.parse("2020-06-09"));
	}

}
