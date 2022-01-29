package one.digitalinovation.gof.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import one.digitalinovation.gof.domain.Address;
import one.digitalinovation.gof.domain.People;
import one.digitalinovation.gof.repositories.PeopleRepository;
import one.digitalinovation.gof.services.AddressService;

@Configuration
public class H2Config implements CommandLineRunner{

	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private AddressService addressService;
	
	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("01001-000");
		address = addressService.autoAddressComplete(address);
		addressService.insertAll(Arrays.asList(address));
		
		People p1 = new People(null, "João", 22, "joão@gmail.com");
		People p2 = new People(null, "Maria", 18, "maria@gmail.com");
		People p3 = new People(null, "Oswaldo", 27, "oswaldo@gmail.com");
		
		address.getHolders().addAll(Arrays.asList(p1, p2, p3));
		p1.getAdresses().add(address);
		p2.getAdresses().add(address);
		p3.getAdresses().add(address);
		
		peopleRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
