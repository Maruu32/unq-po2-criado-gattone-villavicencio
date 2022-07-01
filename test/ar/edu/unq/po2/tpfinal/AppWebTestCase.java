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

import ar.edu.unq.po2.tpfinal.buscador.Filtro;
import ar.edu.unq.po2.tpfinal.organizacion.Organizacion;
import ar.edu.unq.po2.tpfinal.persona.Usuario;
import ar.edu.unq.po2.tpfinal.zonadecobertura.TipoAvisoZona;
import ar.edu.unq.po2.tpfinal.zonadecobertura.ZonaDeCobertura;

class AppWebTestCase {
	
	AplicacionWeb app;			//SUT
	Muestra muestra1; 			//DOC
	Usuario persona1; 			//DOC

	ZonaDeCobertura zona1; 		//DOC
	ZonaDeCobertura zona2; 		//DOC
	ZonaDeCobertura zona3; 		//DOC
	Organizacion organizacion1; //DOC
	Filtro filtro; //DOC

	@BeforeEach
	void setUp() throws Exception {
		muestra1 = mock(Muestra.class);
		persona1 = mock(Usuario.class);
		zona1 = mock(ZonaDeCobertura.class);
		zona2 = mock(ZonaDeCobertura.class);
		zona3 = mock(ZonaDeCobertura.class);
		organizacion1 = mock(Organizacion.class);
		app = new AplicacionWeb();
		filtro = mock(Filtro.class);
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
		verify(zona1, times(1)).notificar(muestra1, TipoAvisoZona.NUEVA_MUESTRA);
		verify(zona2, times(1)).notificar(muestra1, TipoAvisoZona.NUEVA_MUESTRA);
		verify(zona3, times(1)).notificar(muestra1, TipoAvisoZona.NUEVA_MUESTRA);
		
		
	}
	
	@Test
	void testBuscar() {
		app.addMuestra(muestra1);
		
		when(filtro.buscar(app.getMuestras())).thenReturn(new ArrayList<Muestra>());
		
		List<Muestra> resultado = app.buscar(filtro);
		
		verify(filtro, times(1)).buscar(app.getMuestras());
		assertEquals(true, resultado.isEmpty());
	}
	
	
	

}
