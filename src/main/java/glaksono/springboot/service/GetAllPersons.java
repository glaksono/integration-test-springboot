package glaksono.springboot.service;

import glaksono.springboot.repository.PersonRepository;
import glaksono.springboot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPersons {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll(){
        return personRepository.findAll();
    }
}
