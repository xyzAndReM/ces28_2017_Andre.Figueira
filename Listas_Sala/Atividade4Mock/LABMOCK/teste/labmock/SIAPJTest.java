package labmock;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
public class SIAPJTest {
	
	@InjectMocks private SIAPJ siapj;	
	@Mock private IServicoEmail emailMock;
	@Mock private IServicoDB dbMock;
	@Mock private IValidatorProcesso validatorMock;
	@Mock private IProcesso proc1;
	@Mock private IProcesso proc2;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		siapj = new SIAPJ(emailMock, dbMock, validatorMock);
	}
	
	@Test
	public void test() {
		// Exercise 1: Checks if siapj was instatiated
		Assert.assertNotNull(siapj);
	}
	
	@Test
	public void testaCriaReclamacao() throws SQLException {
		Mockito.when(proc1.getEmail()).thenReturn("lucas1jorge@gmail.com");
		Mockito.when(validatorMock.validaProcesso(proc1)).thenReturn(true);
		Mockito.when(validatorMock.validaProcesso(proc2)).thenReturn(false);
		Mockito.when(dbMock.persisteProcesso(proc1)).thenReturn(1);
		Mockito.when(emailMock.sendEmail(proc1.getEmail(), "Processo aceito")).thenReturn(true);
		Mockito.when(emailMock.sendEmail(proc2.getEmail(), "Existem erros em seu processo")).thenReturn(true);
		siapj.criaReclamacao(proc1);
		siapj.criaReclamacao(proc2);
		Mockito.verify(validatorMock, Mockito.times(2)).validaProcesso(Mockito.any());
		Mockito.verify(dbMock, Mockito.times(1)).persisteProcesso(Mockito.any());
		Mockito.verify(emailMock, Mockito.times(2)).sendEmail(Mockito.any(), Mockito.any());
	}

}
