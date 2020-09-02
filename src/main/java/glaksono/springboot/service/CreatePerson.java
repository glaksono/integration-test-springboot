package glaksono.springboot.service;

import glaksono.springboot.repository.PersonRepository;
import glaksono.springboot.entity.Person;
import glaksono.springboot.model.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatePerson {

    @Autowired
    private PersonRepository personRepository;


    public void createPerson(PersonDTO personDTO){
        List<Person> persons = personRepository.findPersonNotMatchUsername(personDTO.getName());
        if(persons.isEmpty()){
            personRepository.save(new Person(personDTO.getName(), personDTO.getPhoneNo()));
        }
    }
}
