package br.edu.ifsp.dsw1.model.dao.link;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class CreateLinkTableListener implements ServletContextListener  {
	
	private static final String CREATE_LINK_TABLE_SQL = "";
	
	public void contextInitialized(ServletContextEvent sce){ 
		try (var conn = DatabaseConnection.getConnection();
       	     var ps = conn.prepareStatement(CREATE_LINK_TABLE_SQL)) {
			ps.executeUpdate();
        }
        catch (Exception e) {
       	 	e.printStackTrace();
        }
   }
}
