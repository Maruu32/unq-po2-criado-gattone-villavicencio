package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.ubicacion.Ubicacion;



class UbicacionTestCase {
	
	Ubicacion ubicacion1; 	//SUT
	Ubicacion ubicacion2; 	//DOC
	Ubicacion ubicacion3; 	//DOC
	Ubicacion ubicacion4; 	//DOC
	Muestra muestra1;		//DOC
	Muestra muestra2;		//DOC
	Muestra muestra3;		//DOC
	Muestra muestra4;		//DOC

	@BeforeEach
	void setUp() throws Exception {
		
		ubicacion1 = new Ubicacion(31.2d, 40.3d);
		ubicacion2 = mock(Ubicacion.class);
		ubicacion3 = mock(Ubicacion.class);
		ubicacion4 = mock(Ubicacion.class);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);
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
	
	@Test
	void testUbicacionesAMenosDe() {
		// Setup
		when(ubicacion2.getLatitud()).thenReturn(35d);
		when(ubicacion2.getLongitud()).thenReturn(45d);
		when(ubicacion3.getLatitud()).thenReturn(30d);
		when(ubicacion3.getLongitud()).thenReturn(25d);
		when(ubicacion4.getLatitud()).thenReturn(5d);
		when(ubicacion4.getLongitud()).thenReturn(65d);
		
		List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
		Collections.addAll(ubicaciones, 
							ubicacion2, 
							ubicacion3,
							ubicacion4);
		
		// excersice
		List<Ubicacion> resultado = ubicacion1.ubicacionesAMenosDe(1500d,ubicaciones);
		
		//Verify
		assertEquals(ubicacion2,resultado.get(0));
		assertEquals(ubicacion3,resultado.get(1));
		verify(ubicacion2, times(1)).getLatitud();
		verify(ubicacion2, times(1)).getLongitud();
		verify(ubicacion3, times(1)).getLatitud();
		verify(ubicacion3, times(1)).getLongitud();
		verify(ubicacion4, times(1)).getLatitud();
		verify(ubicacion4, times(1)).getLongitud();
	}
	
	@Test
	void testUbicacionesAMenosDeNinguna() {
		// Setup
		when(ubicacion4.getLatitud()).thenReturn(5d);
		when(ubicacion4.getLongitud()).thenReturn(65d);
		
		List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
		Collections.addAll(ubicaciones, 
							ubicacion4, 
							ubicacion4,
							ubicacion4);
		
		// excersice
		List<Ubicacion> resultado = ubicacion1.ubicacionesAMenosDe(1500d,ubicaciones);
		
		//Verify
		assertEquals(true,resultado.isEmpty());
		verify(ubicacion4, times(3)).getLatitud();
		verify(ubicacion4, times(3)).getLongitud();
	}
	
	

}
