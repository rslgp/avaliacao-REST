package br.rafael.restapi2.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import br.rafael.restapi2.model.User;

//CRUD JAVA MYSQL

public class MySQLBanco {
	private String url = "jdbc:mysql://localhost/mydatabase";
	private String user = "root";
    private String password = "";
    protected Connection connection;
    protected PreparedStatement preparedStatement;
    
	public MySQLBanco(String url, String user, String password) {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public MySQLBanco() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//DANGEROUS
//	public void runSql(String sqlQuery) {
//		try {
//			preparedStatement = connection.prepareStatement(sqlQuery);
//			ResultSet resultSet = preparedStatement.executeQuery();
//	        while (resultSet.next()) {
//	            int id = resultSet.getInt("id");
//	            String name = resultSet.getString("name");
//	            String email = resultSet.getString("email");
//	            System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
//	        }
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	public void createConta(Map<String, String> payload) {
//		// TODO Auto-generated method stub
//		String numeroConta = payload.get("numero_conta");
//		
//		 String insertQuery = "INSERT INTO conta (numero) VALUES (?)";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
//            preparedStatement.setString(1, numeroConta);
//            int rowsInserted = preparedStatement.executeUpdate();
//            System.out.println("Inserted " + rowsInserted + " row(s)");
//        } catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public String getContaId(Long id) {
//		// TODO Auto-generated method stub
//		String sqlQuery = "select * from conta where id = ?";
//		String result = "";
//		try {
//			preparedStatement = connection.prepareStatement(sqlQuery);
//            preparedStatement.setLong(1, id);
//			ResultSet resultSet = preparedStatement.executeQuery();
//	        while (resultSet.next()) {
//	            Long id2 = resultSet.getLong("id");
//	            Long numero = resultSet.getLong("numero");
//	            
//	            return "{ \"conta_id\": "+id2+", \"numero_documento\":"+numero+"}\n";
//	        }
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
//	public void createTransacao(Map<String, String> payload) {
//		// TODO Auto-generated method stub
//		String numeroConta = payload.get("numero_conta");
//		
//		 String insertQuery = "INSERT INTO transacao (Conta_id, TipoOperacao_id, valor, DataTransacao) VALUES (?,?,?,?)";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
//            preparedStatement.setString(1, payload.get("conta_id"));
//            preparedStatement.setString(2, payload.get("tipo_operacao_id"));
//            preparedStatement.setString(3, payload.get("valor"));
//            
//            preparedStatement.setString(4, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
//            
//            int rowsInserted = preparedStatement.executeUpdate();
//            System.out.println("Inserted " + rowsInserted + " row(s)");
//        } catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	
}

