package one.digitalinovation.gof.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinovation.gof.domain.Address;
import one.digitalinovation.gof.repositories.AddressRepository;
import one.digitalinovation.gof.services.interfaces.ViacepService;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	
	@Autowired
	private ViacepService viacep;
	
	public List<Address> findAll(){
		return repository.findAll();
	}
	
	public Address findByCep(String cep) {
		return repository.findById(cep).get();
	}
	
	public List<Address> insertAll(List<Address> adresses){
		return repository.saveAll(adresses);
	}
	
	public Address insert(Address address) {
		if(address.onlyCepIsNotNull())
			address = autoAddressComplete(address);
		
		return repository.save(address);
	}
	
	public Address update(Address address, String cep) {
		Address a = repository.findById(cep).get();
		if(address.getBairro() != null) a.setBairro(address.getBairro());
		if(address.getComplemento() != null) a.setComplemento(address.getComplemento());
		if(address.getDdd() != null) a.setDdd(address.getDdd());
		if(address.getGia() != null) a.setGia(address.getGia());
		if(address.getIbge() != null) a.setIbge(address.getIbge());
		if(address.getLocalidade() != null) a.setLocalidade(address.getLocalidade());
		if(address.getSiafi() != null) a.setSiafi(address.getSiafi());
		if(address.getUf() != null) a.setUf(address.getUf());
		if(address.getLogradouro() != null) a.setLogradouro(address.getLogradouro());
	
		repository.save(a);
		
		return a;
	}
	
	public Address autoAddressComplete(Address address) {
		return viacep.seeCep(address.getCep());
	}
	
	public void deleteByCep(String cep) {
		repository.deleteById(cep);
	}
	
}
