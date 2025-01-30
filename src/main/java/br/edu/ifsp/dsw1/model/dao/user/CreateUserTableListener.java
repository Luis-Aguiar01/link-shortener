package br.edu.ifsp.dsw1.model.dao.user;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class CreateUserTableListener implements ServletContextListener {
	
	private static final String CREATE_USER_TABLE_SQL = "CREATE TABLE IF NOT EXISTS user (\r\n"
			+ "	   email VARCHAR(50) PRIMARY KEY,\r\n"
			+ "    name VARCHAR(200) NOT NULL,\r\n"
			+ "    password VARCHAR(50) NOT NULL\r\n"
			+ ")";
	
    public void contextInitialized(ServletContextEvent sce)  { 
         try (var conn = DatabaseConnection.getConnection();
        	  var ps = conn.prepareStatement(CREATE_USER_TABLE_SQL)) {
        	 ps.executeUpdate();
         }
         catch (Exception e) {
        	 e.printStackTrace();
         }
    }
}
