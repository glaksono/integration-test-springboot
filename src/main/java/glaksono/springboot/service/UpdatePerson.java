package glaksono.springboot.service;

import glaksono.springboot.repository.PersonRepository;
import glaksono.springboot.entity.Person;
import glaksono.springboot.model.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdatePerson {

    @Autowired
    private PersonRepository personRepository;

    public void update(PersonDTO updatePersonDto, Long id){
        Optional<Person> optionalValue = personRepository.findById(id);
        if(optionalValue.isPresent()){
            Person person = optionalValue.get();
            person.setName(updatePersonDto.getName());
            person.setPhone(updatePersonDto.getPhoneNo());
            personRepository.save(person);
        }
    }
}
