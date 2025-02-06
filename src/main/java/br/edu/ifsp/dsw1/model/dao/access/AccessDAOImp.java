package br.edu.ifsp.dsw1.model.dao.access;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Access;
import br.edu.ifsp.dsw1.model.entity.Link;

class AccessDAOImp implements AccessDAO {
	
	private static final String INSERT_ACCESS_SQL = "INSERT INTO access_tb (ip, short_link) VALUES (?, ?)"; 
	private static final String SELECT_BY_LINK_ACCESS_SQL = "SELECT id, ip FROM access_tb WHERE short_link = ?";
	private static final String COUNT_ACCESS_SQL = "SELECT COUNT(*) FROM access_tb";
	
	@Override
	public boolean create(Link link, String ip) {
		try (var connection = DatabaseConnection.getConnection();
			 var ps = connection.prepareStatement(INSERT_ACCESS_SQL)) {
			
			ps.setString(1, ip);
			ps.setString(2, link.getShortLink());
			return ps.executeUpdate() > 0;
		
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public List<Access> findByLink(Link link) {
		List<Access> accesses = new ArrayList<>();	
		
		try (var connection = DatabaseConnection.getConnection();
			 var ps = connection.prepareStatement(SELECT_BY_LINK_ACCESS_SQL)) {
			
			ps.setString(1, link.getShortLink());
			var result = ps.executeQuery();
			
			while (result.next()) {
				var access = new Access();
						
				access.setId(result.getInt("id"));
				access.setIp(result.getString("ip"));
				
				accesses.add(access);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accesses;
	}
	
	@Override
	public long count() {
		Long accessQuantity = 0L;
		try (var connection = DatabaseConnection.getConnection();
				 var ps = connection.prepareStatement(COUNT_ACCESS_SQL)) {
			
			var count = ps.executeQuery();
	
			if (count.next()) {
				accessQuantity = count.getLong(1);
			}

			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
		return accessQuantity;
		
	}
	
	
}
