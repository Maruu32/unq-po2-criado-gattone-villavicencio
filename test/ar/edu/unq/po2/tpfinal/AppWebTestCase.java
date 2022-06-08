package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppWebTestCase {
	
	AppWeb app; //SUT
	Muestra muestra1; //DOC
	Persona persona1; //DOC
	ZonaDeCobertura zona1; //DOC

	@BeforeEach
	void setUp() throws Exception {
		muestra1 = mock(Muestra.class);
		persona1 = mock(Persona.class);
		zona1 = mock(ZonaDeCobertura.class);
		app = new AppWeb();
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
	void testAddPersona() {
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
	

}
