package br.edu.ifsp.dsw1.model.dao.access;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Access;
import br.edu.ifsp.dsw1.model.entity.Link;

/* AccessDAOImp
 * Classe concreta com os métodos implementados da interface AccessDAO.
 * Essa classe será responsável por ter os métodos de comunicação e obtenção de dados com o Banco, associando a tabela de Acessos
 * Essa tabela guarda informações do IP do usuário e faz associações com a tabela Links para verificação de acessos a utilização de determinado link customizado.
 * */

class AccessDAOImp implements AccessDAO {
	
	/*Querys de inserção, seleção e contabilização de dados na tabela Access*/
	private static final String INSERT_ACCESS_SQL = "INSERT INTO access_tb (ip, short_link) VALUES (?, ?)"; 
	private static final String SELECT_BY_LINK_ACCESS_SQL = "SELECT id, ip FROM access_tb WHERE short_link = ?";
	private static final String COUNT_ACCESS_SQL = "SELECT COUNT(*) FROM access_tb";
	
	/*Método responsável por inserir um novo dado na tabela, obtendo como parâmetro o ip do usuário e o Link customizado que foi acessado.*/
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
	
	/*Método responsável por retornar uma lista contendo todos os acessos que estão associados a determinado link customizado.*/
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
	
	/*Método que retorna a quantidade de acessos já realizados em todo o sistema*/
	@Override
	public long count() {
		Long accessQuantity = 0L;
		try (var connection = DatabaseConnection.getConnection();
			 var ps = connection.prepareStatement(COUNT_ACCESS_SQL)) {
			
			var count = ps.executeQuery();
			if (count.next()) {
				accessQuantity = count.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return accessQuantity;
	}
}
