package one.digitalinovation.gof.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_people")

@NoArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class People{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Include
	@Setter private Long id;
	@Setter private String name;
	@Setter private Integer age;
	@Setter private String email;
	
	@ManyToMany
	@JoinTable(name = "tb_people_address",
			   joinColumns = @JoinColumn(name = "people_id"),
			   inverseJoinColumns = @JoinColumn(name = "cep")
	)
	private Set<Address> adresses = new HashSet<>();

	public People(Long id, String name, Integer age, String email) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
	}
}
