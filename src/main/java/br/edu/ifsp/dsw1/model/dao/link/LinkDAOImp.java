package br.edu.ifsp.dsw1.model.dao.link;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.access.AccessDAO;
import br.edu.ifsp.dsw1.model.dao.access.AccessDAOImp;
import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Access;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.User;
import br.edu.ifsp.dsw1.model.enums.LinkType;

public class LinkDAOImp implements LinkDAO{
	
	private static final String INSERT_LINK_SQL = "INSERT INTO link_tb (short_link, full_link, user_email, type) VALUES (?,?,?, ?)";
	private static final String DELETE_LINK_SQL = "DELETE FROM link_tb WHERE short_link = ?";
	private static final String UPDATE_LINK_SQL = "UPDATE link_tb SET short_link = ?, full_link = ? WHERE short_link = ?";
	private static final String COUNT_LINK_SQL = "SELECT COUNT(*) FROM link_tb";
	private static final String FIND_BY_ID_SQL = "SELECT short_link, full_link, type FROM link_tb WHERE short_link = ?";
	private static final String FIND_BY_USER_SQL = "SELECT short_link, full_link, type FROM link_tb WHERE user_email = ?";
	private AccessDAO databaseAccess;
	
	public LinkDAOImp(AccessDAO daoAccess) {
		databaseAccess = daoAccess;
	}

	@Override
	public boolean create(Link link, String email) {
		try (var connection = DatabaseConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(INSERT_LINK_SQL)){
			
			preparedStatement.setString(1, link.getShortLink());
			preparedStatement.setString(2, link.getFullLink());
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, link.getType().toString());
			
			return preparedStatement.executeUpdate() > 0;
		
		} catch (SQLException exception) {
			return false;
		}
	}
	
	@Override
	public boolean delete(Link link) {
		try (var connection = DatabaseConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(DELETE_LINK_SQL)) {
			
			preparedStatement.setString(1, link.getShortLink());
			return preparedStatement.executeUpdate() > 0;
		
		} catch (SQLException exception) {
			return false;
		}
	}
	
	@Override
	public Link findyById(String shortLink) {
		Link link = null;
		
		try (var connection = DatabaseConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL)) {
			
			preparedStatement.setString(1, shortLink);
			var result = preparedStatement.executeQuery();
			
			if (result.next()) {
				link = new Link();
				link.setShortLink(result.getString("short_link"));
				link.setFullLink(result.getString("full_link"));
				link.setType(LinkType.valueOf(result.getString("type")));
				List<Access> listaAcesso = databaseAccess.findByLink(link);
				link.setListAccess(listaAcesso);
			}
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return link;
	}
	
	
	@Override
	public List<Link> findyByUser(User user) {
		List<Link> links = new ArrayList<>();

		try (var connection = DatabaseConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(FIND_BY_USER_SQL)) {
				
			preparedStatement.setString(1, user.getEmail());	
			var result = preparedStatement.executeQuery();
	
			while (result.next()) {
				var link = new Link();
				link.setShortLink(result.getString("short_link"));
				link.setFullLink(result.getString("full_link"));
				link.setType(LinkType.valueOf(result.getString("type")));
				List<Access> listaAcesso = databaseAccess.findByLink(link);
				link.setListAccess(listaAcesso);
				links.add(link);
				
			}
			
			
				
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return links;
	}

	@Override
	public boolean update(String shortLink, Link link) {
		try (var connection = DatabaseConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(UPDATE_LINK_SQL)){
			
			preparedStatement.setString(1, link.getShortLink()); //Link novo a ser inserido
			preparedStatement.setString(2, link.getFullLink()); 
			preparedStatement.setString(3, shortLink); //Link antigo
			
			return preparedStatement.executeUpdate() > 0;

		}  catch (SQLException exception) {
			return false;
		}
	}
	
	public long count() {
		long linkQuantity = 0L;
		
		try (var connection = DatabaseConnection.getConnection();
			 var preparedStatement = connection.prepareStatement(COUNT_LINK_SQL)) {
			
			var rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				linkQuantity = rs.getLong(1);
			}

		}  catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return linkQuantity;
	}
}
