package br.rafael.restapi2.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.rafael.restapi2.banco.ContaRepository;

public class ServiceConta  {

    private ContaRepository repoConta = new ContaRepository();
    
    @GetMapping("/conta/{id}")
	public Map<String,Object> getContaId(@PathVariable Long id) {
        return repoConta.getContaId(id);
    }


    @PostMapping("/conta")
    public void createConta(@RequestBody Map<String,String> payload) {
    	repoConta.createConta(payload);
    }
}
