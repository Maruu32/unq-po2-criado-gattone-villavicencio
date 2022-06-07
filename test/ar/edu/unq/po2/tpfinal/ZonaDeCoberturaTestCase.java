package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZonaDeCoberturaTestCase {
	
	ZonaDeCobertura zonaDeCobertura; //SUT
	ZonaDeCobertura zonaDeCobertura2; //DOC
	ZonaDeCobertura zonaDeCobertura3; //DOC
	ZonaDeCobertura zonaDeCobertura4; //DOC
	Ubicacion ubicacion1; 	//DOC
	Ubicacion ubicacion2; 	//DOC
	Ubicacion ubicacion3; 	//DOC
	Ubicacion ubicacion4; 	//DOC
	Muestra muestra1;		//DOC
	Muestra muestra2;		//DOC
	Muestra muestra3;		//DOC
	Muestra muestra4;		//DOC
	AplicacionWeb app;		//DOC

	@BeforeEach
	void setUp() throws Exception {
		
		ubicacion1 = mock(Ubicacion.class);
		app = mock(AplicacionWeb.class);
		zonaDeCobertura = new ZonaDeCobertura("Quilmes", ubicacion1, 10d, app);
		ubicacion2 = mock(Ubicacion.class);
		ubicacion3 = mock(Ubicacion.class);
		ubicacion4 = mock(Ubicacion.class);
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);
		zonaDeCobertura2 = mock(ZonaDeCobertura.class);
		zonaDeCobertura3 = mock(ZonaDeCobertura.class);
		zonaDeCobertura4 = mock(ZonaDeCobertura.class);
		
	}

	@Test
	void testMuestasDentroDeZona() {
		// Setup
		when(ubicacion1.distanciaEnKm(ubicacion1)).thenReturn(0d);
		when(ubicacion1.distanciaEnKm(ubicacion2)).thenReturn(10d);
		when(ubicacion1.distanciaEnKm(ubicacion3)).thenReturn(50d);
		when(ubicacion1.distanciaEnKm(ubicacion4)).thenReturn(5555d);
		when(muestra1.getUbicacion()).thenReturn(ubicacion1);
		when(muestra2.getUbicacion()).thenReturn(ubicacion2);
		when(muestra3.getUbicacion()).thenReturn(ubicacion3);
		when(muestra4.getUbicacion()).thenReturn(ubicacion4);
		List<Muestra> muestras = new ArrayList<Muestra>();
		Collections.addAll(muestras, 
							muestra1, 
							muestra2, 
							muestra3, 
							muestra4 
							);
		when(app.getMuestras()).thenReturn(muestras);
		
		// excersice
		List<Muestra> resultado = zonaDeCobertura.muestrasDentroDeZona();
		
		//Verify
		assertEquals(2,resultado.size());
		assertEquals(muestra1,resultado.get(0));
		assertEquals(muestra2,resultado.get(1));
		verify(ubicacion1, times(1)).distanciaEnKm(ubicacion1);
		verify(ubicacion1, times(1)).distanciaEnKm(ubicacion2);
		verify(ubicacion1, times(1)).distanciaEnKm(ubicacion3);
		verify(ubicacion1, times(1)).distanciaEnKm(ubicacion4);
		verify(muestra1, times(1)).getUbicacion();
		verify(muestra2, times(1)).getUbicacion();
		verify(muestra3, times(1)).getUbicacion();
		verify(muestra4, times(1)).getUbicacion();
		verify(app, times(1)).getMuestras();
	}
	
	@Test
	void testZonasSolapadas() {
		// Setup
		when(ubicacion1.distanciaEnKm(ubicacion1)).thenReturn(0d);
		when(ubicacion1.distanciaEnKm(ubicacion2)).thenReturn(15d);
		when(ubicacion1.distanciaEnKm(ubicacion3)).thenReturn(10d);
		when(ubicacion1.distanciaEnKm(ubicacion4)).thenReturn(5555d);
		when(zonaDeCobertura2.getEpicentro()).thenReturn(ubicacion2);
		when(zonaDeCobertura3.getEpicentro()).thenReturn(ubicacion3);
		when(zonaDeCobertura4.getEpicentro()).thenReturn(ubicacion4);
		when(zonaDeCobertura2.getRadio()).thenReturn(5d);
		when(zonaDeCobertura3.getRadio()).thenReturn(10d);
		when(zonaDeCobertura4.getRadio()).thenReturn(200d);
		List<ZonaDeCobertura> zonas = new ArrayList<ZonaDeCobertura>();
		Collections.addAll(zonas, 
							zonaDeCobertura, 
							zonaDeCobertura2, 
							zonaDeCobertura3, 
							zonaDeCobertura4
							);
		when(app.getZonasDeCobertura()).thenReturn(zonas);
		
		// excersice
		List<ZonaDeCobertura> resultado = zonaDeCobertura.zonasSolapadas();
		
		//Verify
		assertEquals(1,resultado.size());
		assertEquals(zonaDeCobertura3,resultado.get(0));
		verify(ubicacion1, times(1)).distanciaEnKm(ubicacion2);
		verify(ubicacion1, times(1)).distanciaEnKm(ubicacion3);
		verify(ubicacion1, times(1)).distanciaEnKm(ubicacion4);
		verify(zonaDeCobertura2, times(1)).getEpicentro();
		verify(zonaDeCobertura3, times(1)).getEpicentro();
		verify(zonaDeCobertura4, times(1)).getEpicentro();
		verify(zonaDeCobertura2, times(1)).getRadio();
		verify(zonaDeCobertura3, times(1)).getRadio();
		verify(zonaDeCobertura4, times(1)).getRadio();
		verify(app, times(1)).getZonasDeCobertura();
	}

}
