package br.edu.ifsp.dsw1.model.dao.access;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAO;
import br.edu.ifsp.dsw1.model.entity.Access;
import br.edu.ifsp.dsw1.model.entity.Link;

public class AccessDAOImp implements AccessDAO{
	
	private static final String INSERT_ACCESS_SQL = "INSET INTO access_tb (ip, link_curto) VALUES (?, ?)"; 
	private static final String SELECT_BY_LINK_ACCESS_SQL = "SELECT ip, link_curto FROM access_tb WHERE link_curto = ?";

	@Override
	public boolean create(Link link, String ip) {
		
		int rows = 0;
		try(var connection = DatabaseConnection.getConnection();
					var ps = connection.prepareStatement(INSERT_ACCESS_SQL)) {
			
			ps.setString(1, ip);
			ps.setString(2, link.getCustomLink());
			
			rows = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return rows > 0;
	}
	 
		
	@Override
	public List<Access> findByLink(Link link, LinkDAO databaseLink) {
		List<Access> listAccess = new ArrayList<>();	
		
		try (var connection = DatabaseConnection.getConnection();
				var ps = connection.prepareStatement(SELECT_BY_LINK_ACCESS_SQL)){
					
					ps.setString(1, link.getCustomLink());
					
					var result = ps.executeQuery();
					
					while(result.next()) {
						Access acesso = new Access();
						String link_curto = result.getString("link");
						Link linkResult = databaseLink.findyById(link_curto);
						
						acesso.setIp(result.getString("ip"));
						acesso.setLink(linkResult);
						listAccess.add(acesso);
					}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listAccess;
	}
}
