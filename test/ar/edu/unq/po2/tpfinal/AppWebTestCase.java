package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppWebTestCase {
	
	AplicacionWeb app;			//SUT
	Muestra muestra1; 			//DOC
	Persona persona1; 			//DOC
	ZonaDeCobertura zona1; 		//DOC
	ZonaDeCobertura zona2; 		//DOC
	ZonaDeCobertura zona3; 		//DOC
	Organizacion organizacion1; //DOC

	@BeforeEach
	void setUp() throws Exception {
		muestra1 = mock(Muestra.class);
		persona1 = mock(Persona.class);
		zona1 = mock(ZonaDeCobertura.class);
		zona2 = mock(ZonaDeCobertura.class);
		zona3 = mock(ZonaDeCobertura.class);
		organizacion1 = mock(Organizacion.class);
		app = new AplicacionWeb();
	}

	@Test
	void testAddMuestra() {
		// excersice		
		app.addMuestra(muestra1);
		
		// verify
		assertEquals(1, app.getMuestras().size());
		assertEquals(true, app.getUsuarios().isEmpty());
		assertEquals(true, app.getZonasDeCobertura().isEmpty());
		assertEquals(true, app.getOrganizaciones().isEmpty());
		
	}
	
	
	@Test
	void testAddUsuario() {
		// excersice		
		app.addUsuario(persona1);
		
		// verify
		assertEquals(true, app.getMuestras().isEmpty());
		assertEquals(1, app.getUsuarios().size());
		assertEquals(true, app.getZonasDeCobertura().isEmpty());
		assertEquals(true, app.getOrganizaciones().isEmpty());
		
	}
	
	@Test
	void testAddZonasDeCobertura() {
		// excersice		
		app.addZonaDeCobertura(zona1);
		
		// verify
		assertEquals(true, app.getMuestras().isEmpty());
		assertEquals(true, app.getUsuarios().isEmpty());
		assertEquals(1, app.getZonasDeCobertura().size());
		assertEquals(true, app.getOrganizaciones().isEmpty());
		
	}
	
	@Test
	void testAddOrganizacion() {
		// excersice		
		app.addOrganizacion(organizacion1);
		
		// verify
		assertEquals(true, app.getMuestras().isEmpty());
		assertEquals(true, app.getUsuarios().isEmpty());
		assertEquals(true, app.getZonasDeCobertura().isEmpty());
		assertEquals(1, app.getOrganizaciones().size());
		
	}
	
	@Test
	void testAvisoNuevaMuestraZonas() {
		//setup
		when(zona1.muestraEstaDentroDeZona(muestra1)).thenReturn(false);
		when(zona2.muestraEstaDentroDeZona(muestra1)).thenReturn(true);
		when(zona3.muestraEstaDentroDeZona(muestra1)).thenReturn(true);
		
		// excersice		
		app.addZonaDeCobertura(zona1);
		app.addZonaDeCobertura(zona2);
		app.addZonaDeCobertura(zona3);
		app.addMuestra(muestra1);
		
		// verify
		assertEquals(1, app.getMuestras().size());
		assertEquals(true, app.getUsuarios().isEmpty());
		assertEquals(3, app.getZonasDeCobertura().size());
		assertEquals(true, app.getOrganizaciones().isEmpty());
		verify(zona1, times(1)).muestraEstaDentroDeZona(muestra1);
		verify(zona2, times(1)).muestraEstaDentroDeZona(muestra1);
		verify(zona3, times(1)).muestraEstaDentroDeZona(muestra1);
		verify(zona2, times(1)).notificar(muestra1, "Nueva muestra");
		verify(zona3, times(1)).notificar(muestra1,"Nueva muestra");
		
	}
	
	
	

}
