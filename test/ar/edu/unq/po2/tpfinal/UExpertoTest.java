package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.muestra.EspecieVinchuca;
import ar.edu.unq.po2.tpfinal.muestra.Muestra;
import ar.edu.unq.po2.tpfinal.muestra.Opinion;
import ar.edu.unq.po2.tpfinal.persona.UExperto;
import ar.edu.unq.po2.tpfinal.persona.Usuario;

class UExpertoTest {
	
		UExperto experto; //sut
		 
		Usuario usr; //doc
		AplicacionWeb ap; //doc
		Muestra muestra;//doc
		
		@BeforeEach
		void setUp(){
			ap = new AplicacionWeb();
			
			usr = new Usuario(null, experto, ap);
			muestra = new Muestra(usr, null, null, null);
			Muestra muestra2 = new Muestra(usr, null, null, null);
			Muestra muestra3 = new Muestra(usr, null, null, null);
			Muestra muestra4 = new Muestra(usr, null, null, null);
			Muestra muestra5 = new Muestra(usr, null, null, null);
			Muestra muestra6 = new Muestra(usr, null, null, null);
			Muestra muestra7 = new Muestra(usr, null, null, null);
			Muestra muestra8 = new Muestra(usr, null, null, null);
			Muestra muestra9 = new Muestra(usr, null, null, null);
			Muestra muestra10 = new Muestra(usr, null, null, null);
			
			experto = new UExperto(); 
			ap.registarUsuario("pepe", experto);
			
			Opinion po1 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po2 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po3 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po4 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po5 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po6 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po7 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po8 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po9 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po10 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po11 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po12 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po13 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po14 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion po15 = new Opinion(usr, muestra10, EspecieVinchuca.VICHUCA_GUASAYANA); 
			
			
			experto.opinar( EspecieVinchuca.VICHUCA_GUASAYANA, usr, muestra10);
			experto.opinar( EspecieVinchuca.VICHUCA_GUASAYANA, usr, muestra10);
			experto.opinar( EspecieVinchuca.VICHUCA_GUASAYANA, usr, muestra10);
			experto.opinar( EspecieVinchuca.VICHUCA_GUASAYANA, usr, muestra10);
			experto.opinar( EspecieVinchuca.VICHUCA_GUASAYANA, usr, muestra10);
			
			
		
		
		}		
		
		@Test
		void test_opinar2() {
			assertFalse(experto.puedeOpinar(muestra));
		}
			
	

}
