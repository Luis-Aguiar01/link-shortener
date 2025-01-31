package br.edu.ifsp.dsw1.model.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.User;

public class UserDAOImp implements UserDAO{
	
	private static final String INSERT_USER_SQL = "INSERT INTO user(email, name, password) VALUES(?, ?, ?)";
	private static final String FIND_BY_EMAIL_SQL = "SELECT email, name, password FROM user WHERE email = ?";
	
	@Override
	public User findByEmail(String email) {
		User user = null;
		
		try (var connection = DatabaseConnection.getConnection(); 
			 var preparedStatement = connection.prepareStatement(FIND_BY_EMAIL_SQL)){
			
			preparedStatement.setString(1, email);
			
			ResultSet result = preparedStatement.executeQuery();
			
			if (result.next()) {
				user = new User();
				user.setEmail(result.getString("email"));
				user.setName(result.getString("name"));
				user.setPassword(result.getString("password"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return user;
	}

	@Override
	public boolean create(User user) {
		int row = 0;
		
		try (var connection = DatabaseConnection.getConnection(); 
			 var preparedStatement = connection.prepareStatement(INSERT_USER_SQL)){
			
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getPassword());
			
			row = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return row > 0;
	}
}
