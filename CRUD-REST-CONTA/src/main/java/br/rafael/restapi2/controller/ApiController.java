package br.rafael.restapi2.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rafael.restapi2.service.ServiceConta;
import br.rafael.restapi2.service.ServiceTransacao;

//CRUD REST + SPRING BOOT

@RestController
@RequestMapping("/api")
public class ApiController {
	//intermediate user and service
    //private MySQLBanco banco = new MySQLBanco();
    private ServiceConta contaService = new ServiceConta();    
    private ServiceTransacao transacaoService = new ServiceTransacao();
    
    @GetMapping("/conta/{id}")
    private String getContaId(@PathVariable Long id) {
        return contaService.getContaId(id);
    }


    @PostMapping("/conta")
    private void createConta(@RequestBody Map<String,String> payload) {
    	contaService.createConta(payload);
    }
    
    @PostMapping("/transacao")
    private void createTransacao(@RequestBody Map<String,String> payload) {
    	transacaoService.createTransacao(payload);
    }
}
