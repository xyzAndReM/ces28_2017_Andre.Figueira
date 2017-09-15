package labmock;

import java.sql.DriverManager;
import java.sql.SQLException;

public interface IServicoDB {
	
	public void getDBConnection();
	public int persisteProcesso(IProcesso proc) ;
}