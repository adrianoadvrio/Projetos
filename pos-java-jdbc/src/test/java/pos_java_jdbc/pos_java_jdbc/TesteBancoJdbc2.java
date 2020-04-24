package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc2 {
	
	@Test
	public void initBanco() {
		
	SingleConnection.getConnection();

	
	
	}

}
