package br.edu.ifsp.dsw1.model.dao.access;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class CreateAccessTableListener implements ServletContextListener  {
	
	private static final String CREATE_ACCESS_TABLE_SQL = "CREATE TABLE IF NOT EXISTS access_tb (\r\n"
			+ "		id INTEGER AUTO_INCREMENT PRIMARY KEY,\r\n"
			+ "		ip VARCHAR(50) NOT NULL,\r\n"
			+ "    	short_link VARCHAR(50) NOT NULL,\r\n"
			+ "    	FOREIGN KEY (short_link) REFERENCES link_tb(short_link)\r\n"
			+ ")";
	
	public void contextInitialized(ServletContextEvent sce){ 
		try (var conn = DatabaseConnection.getConnection();
       	     var ps = conn.prepareStatement(CREATE_ACCESS_TABLE_SQL)) {
			ps.executeUpdate();
        }
        catch (Exception e) {
       	 	e.printStackTrace();
        }
   }
}
