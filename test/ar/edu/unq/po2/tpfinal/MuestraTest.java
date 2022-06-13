package ar.edu.unq.po2.tpfinal;

import static org.junit.jupiter.api.Assertions.*;


import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MuestraTest {
	
		@Test
		void MuestraTest_set_foto() {
			BufferedImage aPhoto = Mockito.mock(BufferedImage.class);
			Opinion aOpinion= Mockito.mock(Opinion.class);
			Ubicacion aUbicacion = Mockito.mock(Ubicacion.class);
			EspecieVinchuca aVichuca = EspecieVinchuca.VICHUCA_GUASAYANA;
			Mockito.when(aOpinion.getTipoMuestra()).thenReturn(aVichuca);
			Usuario aUsuario = Mockito.mock(Usuario.class);
			Mockito.when(aOpinion.getUsuario()).thenReturn(aUsuario);
			
			Muestra SUT = new Muestra(aUbicacion, aPhoto, aOpinion);
			
			assertEquals(aPhoto, SUT.getFoto());
		}
		
		@Test
		void MuestraTest_set_initial_state_to_basic_valiLocalDate_Muestra() {
			BufferedImage aPhoto = Mockito.mock(BufferedImage.class);
			Opinion aOpinion = Mockito.mock(Opinion.class);
			Ubicacion aUbicacion = Mockito.mock(Ubicacion.class);
			EspecieVinchuca aVichuca = EspecieVinchuca.VICHUCA_GUASAYANA;
			Mockito.when(aOpinion.getTipoMuestra()).thenReturn(aVichuca);
			Usuario aUsuario = Mockito.mock(Usuario.class);
			Mockito.when(aOpinion.getUsuario()).thenReturn(aUsuario);
			Muestra SUT = new Muestra(aUbicacion, aPhoto, aOpinion);
			
			assertFalse(SUT.estaVerificada());
		}
		
		@Test
		void MuestraTest_set_Ubicacion() {
			BufferedImage aPhoto = Mockito.mock(BufferedImage.class);
			Opinion aOpinion = Mockito.mock(Opinion.class);
			Ubicacion aUbicacion = Mockito.mock(Ubicacion.class);
			EspecieVinchuca aVichuca = EspecieVinchuca.VICHUCA_GUASAYANA;
			Mockito.when(aOpinion.getTipoMuestra()).thenReturn(aVichuca);
			Usuario aUsuario = Mockito.mock(Usuario.class);
			Mockito.when(aOpinion.getUsuario()).thenReturn(aUsuario);

			
			Muestra SUT = new Muestra(aUbicacion, aPhoto, aOpinion);
			
			assertEquals(aUbicacion, SUT.getUbicacion());
		}
		

		@Test 
		void  testgetTipoGanadorActual_with_tie_return_undefinedCase(){	
			BufferedImage aPhoto = Mockito.mock(BufferedImage.class);
			Opinion aOpinion = Mockito.mock(Opinion.class);
			Ubicacion aUbicacion = Mockito.mock(Ubicacion.class);
			Usuario aUsuario = Mockito.mock(Usuario.class);
			Mockito.when(aOpinion.getUsuario()).thenReturn(aUsuario);
			Mockito.when(aOpinion.getTipoMuestra()).thenReturn(EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion aOpinion2 = Mockito.mock(Opinion.class);
			Mockito.when(aOpinion2.getTipoMuestra()).thenReturn(EspecieVinchuca.VICHUCA_INFESTANS);
			Opinion aOpinion3 = Mockito.mock(Opinion.class);
			Mockito.when(aOpinion3.getTipoMuestra()).thenReturn(EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion aOpinion4 = Mockito.mock(Opinion.class);
			Mockito.when(aOpinion4.getTipoMuestra()).thenReturn(NoEsVinchuca.IMAGEN_POCO_CLARA);
			Opinion aOpinion5 = Mockito.mock(Opinion.class);
			Mockito.when(aOpinion5.getTipoMuestra()).thenReturn(NoEsVinchuca.NINGUNA);
			Opinion aOpinion6 = Mockito.mock(Opinion.class);
			Mockito.when(aOpinion6.getTipoMuestra()).thenReturn(NoEsVinchuca.IMAGEN_POCO_CLARA);
			Muestra SUT = new Muestra(aUbicacion, aPhoto, aOpinion);
			List<Opinion> Opinions = new ArrayList<Opinion>();
			Opinions.add(aOpinion);
			Opinions.add(aOpinion2);
			Opinions.add(aOpinion3);
			Opinions.add(aOpinion4);
			Opinions.add(aOpinion5);
			Opinions.add(aOpinion6);

			ClasificacionMuestra result =  SUT.getTipoGanadorActual(Opinions);
			
			assertEquals(EspecieNoDefinida.UNDEFINED, result);
		}
		
		@Test 
		void  testgetTipoGanadorActual_with_not_tie_return_winner_case(){	
			BufferedImage aPhoto = Mockito.mock(BufferedImage.class);
			Opinion aOpinion = Mockito.mock(Opinion.class);
			Ubicacion aUbicacion = Mockito.mock(Ubicacion.class);
			Usuario aUsuario = Mockito.mock(Usuario.class);
			Mockito.when(aOpinion.getUsuario()).thenReturn(aUsuario);
			Mockito.when(aOpinion.getTipoMuestra()).thenReturn(EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion aOpinion2 = Mockito.mock(Opinion.class);
			Mockito.when(aOpinion2.getTipoMuestra()).thenReturn(EspecieVinchuca.VICHUCA_INFESTANS);
			Opinion aOpinion3 = Mockito.mock(Opinion.class);
			Mockito.when(aOpinion3.getTipoMuestra()).thenReturn(EspecieVinchuca.VICHUCA_GUASAYANA);
			Opinion aOpinion4 = Mockito.mock(Opinion.class);
			Mockito.when(aOpinion4.getTipoMuestra()).thenReturn(NoEsVinchuca.IMAGEN_POCO_CLARA);
			Opinion aOpinion5 = Mockito.mock(Opinion.class);
			Mockito.when(aOpinion5.getTipoMuestra()).thenReturn(NoEsVinchuca.NINGUNA);
			Opinion aOpinion6 = Mockito.mock(Opinion.class);
			Mockito.when(aOpinion6.getTipoMuestra()).thenReturn(NoEsVinchuca.IMAGEN_POCO_CLARA);
			Opinion aOpinion7 = Mockito.mock(Opinion.class);
			Mockito.when(aOpinion7.getTipoMuestra()).thenReturn(EspecieVinchuca.VICHUCA_GUASAYANA);
			Muestra SUT = new Muestra(aUbicacion, aPhoto, aOpinion);
			List<Opinion> Opinions = new ArrayList<Opinion>();
			Opinions.add(aOpinion);
			Opinions.add(aOpinion2);
			Opinions.add(aOpinion3);
			Opinions.add(aOpinion4);
			Opinions.add(aOpinion5);
			Opinions.add(aOpinion6);
			Opinions.add(aOpinion7);

			ClasificacionMuestra result =   SUT.getTipoGanadorActual(Opinions);
			
			assertEquals(EspecieVinchuca.VICHUCA_GUASAYANA, result);
		}


		@Test
		void testUsuarioExpertoPuedeOpinar_delegate_to_state_the_response_on_true_response(){
			BufferedImage aPhoto = Mockito.mock(BufferedImage.class);
			Opinion aOpinion = Mockito.mock(Opinion.class);
			Ubicacion aUbicacion = Mockito.mock(Ubicacion.class);
			Usuario aUsuario = Mockito.mock(Usuario.class);
			Mockito.when(aOpinion.getUsuario()).thenReturn(aUsuario);
			Muestra SUT = new Muestra(aUbicacion, aPhoto, aOpinion);
			MuestraState aState = Mockito.mock(MuestraState.class);
			SUT.setMuestraState(aState);
			Mockito.when(aState.usrExpertoPuedeOpinar(SUT)).thenReturn(true);
			
			boolean result = SUT.getValidacionMuestra().usrExpertoPuedeOpinar(SUT);
			
			assertTrue(result);
			Mockito.verify(aState, Mockito.times(1)).usrExpertoPuedeOpinar(SUT);
		}
		
		@Test
		void usrExpertoPuedeOpinar_delegate_to_state_the_response_on_false_response(){
			BufferedImage aPhoto = Mockito.mock(BufferedImage.class);
			Opinion aOpinion = Mockito.mock(Opinion.class);
			Ubicacion aUbicacion = Mockito.mock(Ubicacion.class);
			Usuario aUsuario = Mockito.mock(Usuario.class);
			Mockito.when(aOpinion.getUsuario()).thenReturn(aUsuario);
			Muestra SUT = new Muestra(aUbicacion, aPhoto, aOpinion);
			MuestraState aState = Mockito.mock(MuestraState.class);
			SUT.setMuestraState(aState);
			Mockito.when(aState.usrExpertoPuedeOpinar(SUT)).thenReturn(false);
			
			boolean result = SUT.getValidacionMuestra().usrExpertoPuedeOpinar(SUT);
			
			assertFalse(result);
			Mockito.verify(aState, Mockito.times(1)).usrExpertoPuedeOpinar(SUT);
		}
		
		@Test
		void testusrBasicoPuedeOpinar_delegate_to_state_the_response_on_true_response(){
			BufferedImage aPhoto = Mockito.mock(BufferedImage.class);
			Opinion aOpinion = Mockito.mock(Opinion.class);
			Ubicacion aUbicacion = Mockito.mock(Ubicacion.class);
			Usuario aUsuario = Mockito.mock(Usuario.class);
			Mockito.when(aOpinion.getUsuario()).thenReturn(aUsuario);
			Muestra SUT = new Muestra(aUbicacion, aPhoto, aOpinion);
			MuestraState aState = Mockito.mock(MuestraState.class);
			SUT.setMuestraState(aState);
			Mockito.when(aState.usrBasicoPuedeOpinar(SUT)).thenReturn(true);
			
			boolean result = SUT.getValidacionMuestra().usrBasicoPuedeOpinar(SUT);
			
			assertTrue(result);
			Mockito.verify(aState, Mockito.times(1)).usrBasicoPuedeOpinar(SUT);
		}
		
		@Test
		void testusrBasicoPuedeOpinar_delegate_to_state_the_response_on_false_response(){
			BufferedImage aPhoto = Mockito.mock(BufferedImage.class);
			Opinion aOpinion = Mockito.mock(Opinion.class);
			Ubicacion aUbicacion = Mockito.mock(Ubicacion.class);
			Usuario aUsuario = Mockito.mock(Usuario.class);
			Mockito.when(aOpinion.getUsuario()).thenReturn(aUsuario);
			Muestra SUT = new Muestra(aUbicacion, aPhoto, aOpinion);
			MuestraState aState = Mockito.mock(MuestraState.class);
			SUT.setMuestraState(aState);
			Mockito.when(aState.usrBasicoPuedeOpinar(SUT)).thenReturn(false);
			
			boolean result = SUT.getValidacionMuestra().usrBasicoPuedeOpinar(SUT);
			
			assertFalse(result);
			Mockito.verify(aState, Mockito.times(1)).usrBasicoPuedeOpinar(SUT);
		}
	
	}

