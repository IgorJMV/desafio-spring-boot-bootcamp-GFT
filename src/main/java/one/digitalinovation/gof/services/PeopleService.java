package one.digitalinovation.gof.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinovation.gof.domain.People;
import one.digitalinovation.gof.repositories.PeopleRepository;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository repository;
	
	public List<People> findAll(){
		return repository.findAll();
	}
	
	public People findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<People> insertAll(Iterable<People> peoples) {
		return repository.saveAll(peoples);
	}
	
	public People insert(People people) {
		return repository.save(people);
	}
	
	public People update(People people, Long id) {
		People p = repository.findById(id).get();
		if(people.getName() != null) p.setName(people.getName());
		if(people.getAge() != null) p.setAge(people.getAge());
		if(people.getEmail() != null) p.setEmail(people.getEmail());
		
		if(people.getAdresses() != null) {
			p.getAdresses().clear();
			p.getAdresses().addAll(people.getAdresses());
		}
		
		repository.save(p);
		
		return p;
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}
