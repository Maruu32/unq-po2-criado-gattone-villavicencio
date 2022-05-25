package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class UbicacionTestCase {
	
	Ubicacion ubicacion1; //SUT
	Ubicacion ubicacion2; //DOC

	@BeforeEach
	void setUp() throws Exception {
		
		ubicacion1 = new Ubicacion(31.2d, 40.3d);
		ubicacion2 = mock(Ubicacion.class);

	}

	@Test
	void testDistanciaMismoPunto() {
		// excersice
		double resultado = ubicacion1.distanciaEnKm(ubicacion1);
		
		//Verify
		assertEquals(0d,resultado);
	}
	
	@Test
	void testDistanciaOtroPunto() {
		// Setup
		when(ubicacion2.getLatitud()).thenReturn(35d);
		when(ubicacion2.getLongitud()).thenReturn(45d);
		
		// excersice
		double resultado = ubicacion1.distanciaEnKm(ubicacion2);
		
		//Verify
		assertEquals(608.29d,resultado, 0.1d);
		verify(ubicacion2, times(1)).getLatitud();
		verify(ubicacion2, times(1)).getLongitud();
	}

}
