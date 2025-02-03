package br.edu.ifsp.dsw1.model.dao.link;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class CreateLinkTableListener implements ServletContextListener  {
	
	private static final String CREATE_LINK_TABLE_SQL = "CREATE TABLE IF NOT EXISTS link_tb (\r\n"
	        + "    short_link VARCHAR(20) PRIMARY KEY,\r\n"
	        + "    full_link VARCHAR(300) NOT NULL,\r\n"
	        + "    user_email VARCHAR(50),\r\n"
	        + "    type ENUM('RANDOM', 'CUSTOM') NOT NULL,\r\n"
	        + "    FOREIGN KEY (user_email) REFERENCES user_tb(email) ON DELETE CASCADE\r\n"
	        + ")";
	
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
