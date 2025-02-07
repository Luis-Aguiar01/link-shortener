package br.edu.ifsp.dsw1.model.dao.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAO;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.User;

/*Classe concreta com a implementação do métodos da interface UserDAO*/
class UserDAOImp implements UserDAO{
	
	/*Querys da tabela user_tb*/
	private static final String INSERT_USER_SQL = "INSERT INTO user_tb(email, name, password) VALUES(?, ?, ?)";
	private static final String FIND_BY_EMAIL_SQL = "SELECT email, name, password FROM user_tb WHERE email = ?";
	
	private LinkDAO databaseLink;
	
	public UserDAOImp(LinkDAO database) {
		databaseLink = database;
	}
	
	/*Método para a inserção de novos usuários na tabela do banco de dados.*/
	@Override
	public boolean create(User user) {
		try (var connection = DatabaseConnection.getConnection(); 
			 var preparedStatement = connection.prepareStatement(INSERT_USER_SQL)){
			
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getPassword());
			
			return preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			return false;
		}
	}
	
	/*Método para retornar um objeto User, com as informações retiradas do 
	 * banco de dados de acordo com o parâmetro passado.*/
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
				List<Link> listaLink = databaseLink.findByUser(user);
				user.setLinks(listaLink);
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return user;
	}
}
