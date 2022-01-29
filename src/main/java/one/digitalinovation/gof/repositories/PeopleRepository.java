package one.digitalinovation.gof.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalinovation.gof.domain.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long>{

}
