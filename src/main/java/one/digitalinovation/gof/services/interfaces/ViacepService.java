package one.digitalinovation.gof.services.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import one.digitalinovation.gof.domain.Address;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViacepService {
	
	@GetMapping("/{cep}/json/")
	public Address seeCep(@PathVariable("cep") String cep);
	
}
