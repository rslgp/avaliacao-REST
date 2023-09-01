package br.rafael.restapi2.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rafael.restapi2.banco.MySQLBanco;
import br.rafael.restapi2.model.User;

//CRUD REST + SPRING BOOT

@RestController
@RequestMapping("/api")
public class ApiController {
    private MySQLBanco banco = new MySQLBanco();
    private Long nextId = 1L;

    @GetMapping("/conta/{id}")
    public String getContaId(@PathVariable Long id) {
        return banco.getContaId(id);
    }


    @PostMapping("/conta")
    private void createConta(@RequestBody Map<String,String> payload) {
    	banco.createConta(payload);
    }
    
    @PostMapping("/transacao")
    private void createTransacao(@RequestBody Map<String,String> payload) {
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
    	
    	banco.createTransacao(payload);
    }
    
}
