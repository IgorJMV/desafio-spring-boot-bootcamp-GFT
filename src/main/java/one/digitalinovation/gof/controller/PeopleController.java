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

import one.digitalinovation.gof.domain.People;
import one.digitalinovation.gof.services.PeopleService;

@RestController
@RequestMapping("peoples")
public class PeopleController {
	
	@Autowired
	private PeopleService service;
	
	@GetMapping
	public ResponseEntity<List<People>> findAll(){
		List<People> peoples = service.findAll();
		return ResponseEntity.ok().body(peoples);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<People> findById(@PathVariable Long id){
		People p = service.findById(id);
		return ResponseEntity.ok().body(p);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody People people){
		people = service.insert(people);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(people.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<People> update(@RequestBody People people, @PathVariable Long id){
		service.update(people, id);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
