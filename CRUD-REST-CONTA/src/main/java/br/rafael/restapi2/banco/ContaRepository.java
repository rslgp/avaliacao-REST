package br.rafael.restapi2.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ContaRepository extends MySQLBanco {
	
	private final String tabela = "conta";
	
	public void createConta(Map<String, String> payload) {
		String numeroConta = payload.get("numero_conta");
		
		 String insertQuery = "INSERT INTO "+tabela+" (numero) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, numeroConta);
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Inserted " + rowsInserted + " row(s)");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public String getContaId(Long id) {
		// TODO Auto-generated method stub
		String sqlQuery = "select * from "+tabela+" where id = ?";
		String result = "";
		try {
			preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            Long id2 = resultSet.getLong("id");
	            Long numero = resultSet.getLong("numero");
	            
	            return "{ \"conta_id\": "+id2+", \"numero_documento\":"+numero+"}\n";
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
