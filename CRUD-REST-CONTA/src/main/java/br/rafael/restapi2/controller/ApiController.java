package br.rafael.restapi2.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.rafael.restapi2.service.ServiceConta;
import br.rafael.restapi2.service.ServiceTransacao;

//CRUD REST + SPRING BOOT (API LAYER <> SERVICE LAYER <> DATA ACCESS LAYER)

@RestController
@RequestMapping("/api")
public class ApiController {
	//intermediate user and service
    //private MySQLBanco banco = new MySQLBanco();
    private ServiceConta contaService = new ServiceConta();    
    private ServiceTransacao transacaoService = new ServiceTransacao();
    
    /*
     * GET STATEMENTS
     * */
    @GetMapping("/conta/{id}")
    private Map<String,Object> getContaId(@PathVariable Long id) {
        return contaService.getContaId(id);
    }


    /*
     * POST STATEMENTS
     * */
    @PostMapping("/conta")
    private void createConta(@RequestBody Map<String,String> payload) {
    	contaService.createConta(payload);
    }
    
    @PostMapping("/transacao")
    private void createTransacao(@RequestBody Map<String,String> payload) {
    	transacaoService.createTransacao(payload);
    }
    

    /*
     * PUT STATEMENTS
     * */
    

    /*
     * DELETE STATEMENTS
     * */
}
