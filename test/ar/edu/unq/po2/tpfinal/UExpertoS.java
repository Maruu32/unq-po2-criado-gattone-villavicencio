package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpfinal.persona.UExpertoSiempre;
import ar.edu.unq.po2.tpfinal.persona.Usuario;

class UExpertoS {

	UExpertoSiempre experto; //sut
	 
	Usuario usr; //doc
	AplicacionWeb ap; //doc
	Muestra muestra;//doc
	
	@BeforeEach
	void setUp(){
		ap = new AplicacionWeb();
		usr = new Usuario(null, experto);
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
		
		experto = new UExpertoSiempre(); 
		ap.registarUsuario("pepe", experto);
	
	
	}		
	
	@Test
	void test_opinar() {
		assertFalse(experto.puedeOpinar(muestra));
	}
		


}