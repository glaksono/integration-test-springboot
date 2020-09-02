package glaksono.springboot.service;

import glaksono.springboot.entity.Person;
import glaksono.springboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePerson {

    @Autowired
    private PersonRepository personRepository;

    public void delete(Long id){
        Optional<Person> optionalValue = personRepository.findById(id);
        if(optionalValue.isPresent()){
            personRepository.delete(optionalValue.get());
        }
    }
}
