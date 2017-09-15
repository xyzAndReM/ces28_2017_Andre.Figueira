import static org.junit.Assert.*;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ControladorPTCTest{
	
	@Mock
	private Sensor sensor;
	
	@Mock
	private Datacenter dataCenter;
	
	@Mock
	private PainelCondutor painelCond;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void TestandoInicializacaoDoControlador() {
		ControladorPTC a = new ControladorPTC(sensor,dataCenter,painelCond);
		assertNotNull(sensor);
		assertNotNull(dataCenter);
		assertNotNull(painelCond);
        assertNotNull(a);
        
	}
	
	@Test
	public void TremNaoEstaEmCruzamentoChamarGerarRelatorioEimprimirAviso() {
		ControladorPTC a = new ControladorPTC(sensor,dataCenter,painelCond);
		Mockito.when(sensor.getVelocidade()).thenReturn(10.0);
		Mockito.when(sensor.isCruzamento()).thenReturn(false);
		a.run();
		verify(dataCenter, times(1)).gerarRelatorio("10.0");
		verify(painelCond,times(1)).imprimirAviso("10.0", 1); 
	}
	
	@Test
	public void TremNaoEstaEmCruzamentoEAcimaDoLimite() {
		ControladorPTC a = new ControladorPTC(sensor,dataCenter,painelCond);
		Mockito.when(sensor.getVelocidade()).thenReturn(120.0);
		Mockito.when(sensor.isCruzamento()).thenReturn(true);
		Mockito.when(painelCond.imprimirAviso("Velocidade alta",1)).thenReturn(true);
		a.run();
		verify(painelCond,times(1)).imprimirAviso("Velocidade alta", 1);
		verify(painelCond, times(0)).diminuiVelocidadeTrem(20.0); 
	}
	
	@Test
	public void TremEstaEmCruzamentoMasAbaixoDe20() {
		ControladorPTC a = new ControladorPTC(sensor,dataCenter,painelCond);
		Mockito.when(sensor.getVelocidade()).thenReturn(10.0);
		Mockito.when(sensor.isCruzamento()).thenReturn(true);
		Mockito.when(painelCond.imprimirAviso("Velocidade alta",1)).thenReturn(false);
		a.run();
		verify(painelCond,times(2)).imprimirAviso("Velocidade Baixa", 1); //
		verify(painelCond, times(1)).aceleraVelocidadeTrem(20.0); 
	}
}
