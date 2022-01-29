package one.digitalinovation.gof.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import one.digitalinovation.gof.domain.Address;
import one.digitalinovation.gof.services.AddressService;

@RestController
@RequestMapping("adresses")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@GetMapping
	public ResponseEntity<List<Address>> findAll(){
		List<Address> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{cep}")
	public ResponseEntity<Address> findById(@PathVariable("cep") String cep){
		Address a = service.findByCep(cep);
		return ResponseEntity.ok().body(a);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Address address){
		address = service.insert(address);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cep}").buildAndExpand(address.getCep()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{cep}")
	public ResponseEntity<Address> update(@RequestBody Address address, @PathVariable String cep){
		service.update(address, cep);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{cep}")
	public ResponseEntity<Void> deleteByCep(@PathVariable("cep") String cep){
		service.deleteByCep(cep);
		
		return ResponseEntity.noContent().build();
	}	
}
