package br.rafael.restapi2.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class ContaRepository extends MySQLBanco {
	
	private final String tabela = "contaslimite";
	
	public void createConta(Map<String, String> payload) {
		
		String numeroConta = payload.get("numero_conta");
		String limite = payload.get("limite");
		String data = payload.get("data_limite");
		
		 String insertQuery = "INSERT INTO "+tabela+" (conta_id, limite, data_limite) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, numeroConta);
            preparedStatement.setString(2, limite);
            preparedStatement.setString(3, data);
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Inserted " + rowsInserted + " row(s)");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public Map<String, Object> getContaId(Long id) {
		
		String sqlQuery = "select * from "+tabela+" where id = ?";
		String result = "";
		try {
			preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            Long id2 = resultSet.getLong("id");
	            Long numero = resultSet.getLong("conta_id");
	            Double limite = resultSet.getDouble("limite");
	            String data = resultSet.getString("data_limite");
	            
	            
	            return Map.of("conta_id",id2,"numero_documento",numero.toString(),"limite",limite,"data_limite",data);
	            //return "{ \"conta_id\": "+id2+", \"numero_documento\":"+numero+"}\n";
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateLimite(Long contaid, Double limite) {
    	String updateQuery = "UPDATE "+tabela+" SET limite = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setDouble(1, limite);
            preparedStatement.setLong(2, contaid);
            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println("Updated " + rowsUpdated + " row(s)");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}


	public String getLimiteContaId(Long id) {
		String sqlQuery = "select * from "+tabela+" where id = ?";
		String result = "";
		try {
			preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            Long id2 = resultSet.getLong("id");
	            Long numero = resultSet.getLong("conta_id");
	            Double limite = resultSet.getDouble("limite");
	            String data = resultSet.getString("data_limite");
	            
	            
	            return limite+"";
	            //return "{ \"conta_id\": "+id2+", \"numero_documento\":"+numero+"}\n";
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
