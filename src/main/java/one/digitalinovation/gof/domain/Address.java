package one.digitalinovation.gof.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_address")

@NoArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Include
	@Setter private String cep;
	@Setter private String logradouro;
	@Setter private String complemento;
	@Setter private String bairro;
	@Setter private String localidade;
	@Setter private String uf;
	@Setter private String ibge;
	@Setter private String gia;
	@Setter private String ddd;
	@Setter private String siafi;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "adresses")
	private Set<People> holders = new HashSet<>();

	public Address(String cep) {
		this.cep = cep;
	}
	
	public Boolean onlyCepIsNotNull() {
		if(cep != null && logradouro == null && complemento == null &&
		   bairro == null && localidade == null && uf == null && ibge == null &&
		   gia == null && ddd == null && siafi == null)
			return true;
		
		return false;
	}
}
