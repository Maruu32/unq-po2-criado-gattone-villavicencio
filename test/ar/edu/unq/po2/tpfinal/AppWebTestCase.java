package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppWebTestCase {
	
	AppWeb app; //SUT
	Muestra muestra1; //DOC
	Persona persona1; //DOC

	@BeforeEach
	void setUp() throws Exception {
		muestra1 = mock(Muestra.class);
		persona1 = mock(Persona.class);
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

}
