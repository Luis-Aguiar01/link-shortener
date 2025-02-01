package br.edu.ifsp.dsw1.model.dao.link;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.User;

public class LinkDAOImp implements LinkDAO{
	
	private static final String INSERT_LINK_SQL = "INSERT INTO link (link_curto, link_original, user) VALUES (?,?,?)";
	private static final String DELETE_LINK_SQL = "DELETE FROM link WHERE link_curto = ?";
	private static final String UPDATE_LINK_SQL = "UPDATE link SET link_curto = ? WHERE link_curto = ?";
	private static final String FIND_BY_ID_SQL = "SELECT link_curto, link_original FROM link WHERE link_curto = ?";
	private static final String FIND_BY_USER_SQL = "SELECT link_curto, link_original FROM link WHERE user = ?";

	@Override
	public boolean create(Link link, String email) {
		int rows = 0;
		
		try (var connection = DatabaseConnection.getConnection();
					var preparedStatement = connection.prepareStatement(INSERT_LINK_SQL)){
			
			preparedStatement.setString(1, link.getCustomLink());
			preparedStatement.setString(2, link.getLink());
			preparedStatement.setString(3, email);
			
			rows = preparedStatement.executeUpdate();
			
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return rows > 0;

	}
	
	@Override
	public boolean delete(Link link) {
		
		int rows = 0;
		
		try(var connection = DatabaseConnection.getConnection();
					var preparedStatement = connection.prepareStatement(DELETE_LINK_SQL) ){
			
			preparedStatement.setString(1, link.getCustomLink());
			
			rows = preparedStatement.executeUpdate();
			
			
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		return rows > 0;
	}
	
	@Override
	public Link findyById(String linkCustom) {
		Link link = null;
		
		try (var connection = DatabaseConnection.getConnection();
					var preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL) ){
			
			preparedStatement.setString(1, linkCustom);
			
			var result = preparedStatement.executeQuery();
			
			if (result.next()) {
				link = new Link();
				link.setCustomLink(result.getString("link_curto"));
				link.setLink(result.getString("link_original"));
			}
			
			return link;
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		return null;
	}
	
	
	@Override
	public List<Link> findyByUser(User user) {
		List<Link> listLinks = new ArrayList<>();

		
		try (var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(FIND_BY_USER_SQL)){
					
				preparedStatement.setString(1, user.getEmail());	
			
				var result = preparedStatement.executeQuery();
				
				
				Link link;
				while (result.next()) {
					
					 link = new Link();
					 link.setCustomLink(result.getString("link_curto"));
					 link.setLink(result.getString("link_original"));
					 listLinks.add(link);
				}
				
						
		} catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		
		return listLinks;
	}

	@Override
	public boolean update(String link_curto, Link link) {
		int rows = 0;
		
		try (var connection = DatabaseConnection.getConnection();
				var preparedStatement = connection.prepareStatement(UPDATE_LINK_SQL)){
			
			preparedStatement.setString(1, link_curto); //Link novo a ser inserido
			preparedStatement.setString(2, link.getCustomLink()); //Link antigo
			
			rows = preparedStatement.executeUpdate();

		}  catch (SQLException exception) {
			exception.printStackTrace();
		}
		
		
		return rows > 0;
	}
}
