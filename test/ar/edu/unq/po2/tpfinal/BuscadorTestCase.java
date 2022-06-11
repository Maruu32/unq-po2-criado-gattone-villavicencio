package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BuscadorTestCase {
	
	Buscador buscador1; 				//SUT
	AplicacionWeb app; 					//DOC
	List<Muestra> muestras;				//DOC
	Muestra muestra0;				//DOC
	Muestra muestra1;				//DOC
	Muestra muestra2;				//DOC
	EstrategiaDeBusqueda eBusqueda1;	//DOC

	@BeforeEach
	void setUp() throws Exception {
		eBusqueda1 = mock(EstrategiaDeBusqueda.class);
		app = mock(AplicacionWeb.class);
		muestra0 = mock(Muestra.class);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestras = new ArrayList<Muestra>();
		buscador1 = new Buscador(app);
	}

	@Test
	void testBuscar() {
		//Setup
		muestras.add(muestra0);
		muestras.add(muestra1);
		muestras.add(muestra2);
		when(app.getMuestras()).thenReturn(muestras);
				
		//Excersice
		buscador1.buscar(eBusqueda1);
		
		//Verify
		assertEqual(eBusqueda1, buscador1.getEstrategiaBusqueda());
		verify(app, times(1)).getMuestras();
		verify(eBusqueda1, times(1)).buscar(muestras);
		
	}

}
