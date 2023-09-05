package br.rafael.restapi2.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.rafael.restapi2.banco.ContaRepository;
import br.rafael.restapi2.banco.TransacaoRepository;


//cria um bean, para ser usado junto com o autowired, dependency injection
@Service
public class ServiceTransacao{
	private final TransacaoRepository repoTransacao = new TransacaoRepository();
	private final ContaRepository repoConta = new ContaRepository();
    
    public int createTransacao(Map<String,String> payload) throws Exception {
    	//AUTO AJUSTAR converter sozinho caso venha valor errado
    	String tipoTransacao = payload.get("tipo_operacao_id");
		Double valor = Double.parseDouble(payload.get("valor"));
    	switch(tipoTransacao) {
    		case "1":;
    		case "2":
    		case "3":
    			if(valor>0) payload.put("valor", (valor * -1)+"");
    			break;
    		case "4":
    			if(valor<0) payload.put("valor", (valor * -1)+"");
    			break;
    	}
    	
    	Long contaid = Long.parseLong(payload.get("conta_id"));
    	Map<String,Object> m = repoConta.getContaId(contaid);
    	Double limite = (Double) m.get("limite");

    	valor = Double.parseDouble(payload.get("valor"));
        	
    	//se o valor esta dentro do limite
    	if(limite >= Math.abs(valor)) {
    		limite += valor;
    	}else {
    		throw new Exception("valor acima do limite");
    	}
    	
    	if(tipoTransacao=="4") {
    		limite+=valor;
    	}
    	
    	repoConta.updateLimite(contaid, limite);
    	
    	repoTransacao.createTransacao(payload);
    	
    	return 200;
    }
}
