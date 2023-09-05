package br.rafael.restapi2.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import br.rafael.restapi2.banco.ContaRepository;

//cria um bean, para ser usado junto com o autowired, dependency injection
@Service
public class ServiceConta  {

    private final ContaRepository repoConta = new ContaRepository();
    
	public Map<String,Object> getContaId(Long id) {
        return repoConta.getContaId(id);
    }


    public void createConta(Map<String,String> payload) {
    	repoConta.createConta(payload);
    }
}
