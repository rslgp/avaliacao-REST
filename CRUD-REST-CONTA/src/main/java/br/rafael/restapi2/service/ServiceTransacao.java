package br.rafael.restapi2.service;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.rafael.restapi2.banco.TransacaoRepository;

public class ServiceTransacao{
	private TransacaoRepository repoTransacao = new TransacaoRepository();
    
    @PostMapping("/transacao")
    public void createTransacao(@RequestBody Map<String,String> payload) {
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
    	
    	repoTransacao.createTransacao(payload);
    }
}
