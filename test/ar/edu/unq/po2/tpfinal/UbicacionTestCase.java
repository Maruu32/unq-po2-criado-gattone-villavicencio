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
		assertEquals(0d,ubicacion1.distancia(ubicacion1));
	}

}
