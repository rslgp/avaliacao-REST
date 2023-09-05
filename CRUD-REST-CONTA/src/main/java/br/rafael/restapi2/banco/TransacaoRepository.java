package br.rafael.restapi2.banco;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class TransacaoRepository extends MySQLBanco {

	private final String tabela = "transacao";
	
	public void createTransacao(Map<String, String> payload) {
		
		String insertQuery = "INSERT INTO "+tabela+" (Conta_id, TipoOperacao_id, valor, DataTransacao) VALUES (?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, payload.get("conta_id"));
            preparedStatement.setString(2, payload.get("tipo_operacao_id"));
            preparedStatement.setString(3, payload.get("valor"));
            
            preparedStatement.setString(4, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("Inserted " + rowsInserted + " row(s)");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
