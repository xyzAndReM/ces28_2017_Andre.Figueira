package labmock;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
public class SIAPJTest3 {
	@InjectMocks private SIAPJ siapj;	
	@Mock private IServicoEmail emailMock;
	@Mock private IServicoDB dbMock;
	@Mock private IValidatorProcesso validatorMock;
	@Mock private IProcesso proc1;
	@Mock private IProcesso proc2;
	
	@Mock private Connection mockConnection;
	@Mock private java.sql.Statement mockStatement;
	
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
		Mockito.when(proc2.getEmail()).thenReturn("a.marcello92@gmail.com");
		
		Mockito.when(validatorMock.validaProcesso(proc1)).thenReturn(true);
		Mockito.when(validatorMock.validaProcesso(proc2)).thenReturn(false);
		Mockito.when(dbMock.persisteProcesso(proc1)).thenReturn(1);
		
		Mockito.when(emailMock.sendEmail(proc1.getEmail(), "Processo aceito")).thenReturn(true);
		Mockito.when(emailMock.sendEmail(proc2.getEmail(), "Existem erros em seu processo")).thenReturn(true);
		
		Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
		Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
		
		siapj.criaReclamacao(proc1);
		siapj.criaReclamacao(proc2);
	}

}
