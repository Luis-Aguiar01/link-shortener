package br.edu.ifsp.dsw1.model.dao.access;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class CreateAccessTableListener implements ServletContextListener  {
	
	private static final String CREATE_ACCESS_TABLE_SQL = "CREATE TABLE IF NOT EXISTS access_tb(\r\n"
			+ "	id INTEGER AUTO_INCREMENT PRIMARY KEY,\r\n"
			+ "	ip VARCHAR(200) NOT NULL,\r\n"
			+ "    link_curto VARCHAR(200) NOT NULL,\r\n"
			+ "    \r\n"
			+ "    FOREIGN KEY (link_curto) REFERENCES link(link_curto)\r\n"
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
