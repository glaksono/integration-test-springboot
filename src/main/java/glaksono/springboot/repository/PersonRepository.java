package glaksono.springboot.repository;

import glaksono.springboot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.name != ?1")
    List<Person> findPersonNotMatchUsername(String username);
}
