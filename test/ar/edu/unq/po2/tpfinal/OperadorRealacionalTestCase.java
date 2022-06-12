package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperadorRealacionalTestCase {
	OperadorRelacionalFechas igual;
	OperadorRelacionalFechas mayor;
	OperadorRelacionalFechas menor;
	OperadorRelacionalFechas mayorIgual;
	OperadorRelacionalFechas menorIgual;
	LocalDate fecha1;
	LocalDate fecha2;
	LocalDate fecha3;
	

	@BeforeEach
	void setUp() throws Exception {
		igual = new Igual();
		mayor = new Mayor();
		menor = new Menor();
		mayorIgual = new MayorIgual();
		menorIgual = new MenorIgual();
		fecha1 = LocalDate.parse("2020-06-09");
		fecha2 = LocalDate.parse("2020-06-09");
		fecha3 = LocalDate.parse("2020-06-10");
		
	}

	@Test
	void testIgual() {
		assertEquals(true, igual.evaluar(fecha2, fecha1));
		assertEquals(false, igual.evaluar(fecha3, fecha1));
	}
	
	@Test
	void testMayor() {
		assertEquals(true, mayor.evaluar(fecha3, fecha1));
		assertEquals(false, mayor.evaluar(fecha2, fecha1));
	}
	
	@Test
	void testMenor() {
		assertEquals(false, menor.evaluar(fecha2, fecha1));
		assertEquals(false, menor.evaluar(fecha1, fecha2));
		assertEquals(true, menor.evaluar(fecha2, fecha3));
	}
	
	@Test
	void testMayorIgual() {
		assertEquals(true, mayorIgual.evaluar(fecha2, fecha1));
		assertEquals(true, mayorIgual.evaluar(fecha3, fecha1));
		assertEquals(false, mayorIgual.evaluar(fecha1, fecha3));
	}
	
	@Test
	void testMenorIgual() {
		assertEquals(true, menorIgual.evaluar(fecha2, fecha1));
		assertEquals(false, menorIgual.evaluar(fecha3, fecha1));
		assertEquals(true, menorIgual.evaluar(fecha1, fecha3));
	}
}
