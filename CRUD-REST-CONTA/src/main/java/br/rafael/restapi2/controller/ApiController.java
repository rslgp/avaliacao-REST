package br.rafael.restapi2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private final ServiceConta contaService;    
    private final ServiceTransacao transacaoService;
    
    //instead use new Service() no global, usa dependecy injection
    @Autowired
    public ApiController(ServiceConta contaService, ServiceTransacao transacaoService) {
    	this.contaService=contaService;
    	this.transacaoService=transacaoService;
	}
    
    /*
     * GET STATEMENTS
     * */
    @GetMapping("/conta/{id}")
    private Map<String,Object> getContaId(@PathVariable Long id) {
        return contaService.getContaId(id);
    }
    @GetMapping("/consultar_limite/conta/{id}")
    private String getLimiteContaId(@PathVariable Long id) {
        return contaService.getLimiteContaId(id);
    }
    
//    @GetMapping("/hello")
//    private List<User> hello(){
//    	return List.of(new User("rafael", "rafael@gmail.com"));
//    }

    /*
     * POST STATEMENTS
     * */
    @PostMapping("/conta")
    private void createConta(@RequestBody Map<String,String> payload) {
    	contaService.createConta(payload);
    }
    
    @PostMapping("/transacao")
    private ResponseEntity<Object> createTransacao(@RequestBody Map<String,String> payload) {
    	try {
			return ResponseEntity.ok(transacaoService.createTransacao(payload) );
		} catch (Exception e) {
			String msgError="valor acima do limite";
			System.err.println(msgError);
			return ResponseEntity.badRequest().body(msgError);
		}
    }
    

    /*
     * PUT STATEMENTS
     * */
    

    /*
     * DELETE STATEMENTS
     * */
}
