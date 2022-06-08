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
		app.add(muestra1, persona1);
		// verify
		assertEqual(1, app.getMuestras().size());
		assertEqual(0, app.getUsuarios().size());
		assertEqual(0, app.getZonasDeCobertura().size());
		assertEqual(0, app.getOrganizaciones().size());
		
	}

}
