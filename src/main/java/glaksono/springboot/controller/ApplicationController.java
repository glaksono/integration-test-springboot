package glaksono.springboot.controller;

import glaksono.springboot.model.PersonDTO;
import glaksono.springboot.service.CreatePerson;
import glaksono.springboot.service.DeletePerson;
import glaksono.springboot.service.GetAllPersons;
import glaksono.springboot.service.UpdatePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class ApplicationController {

    @Autowired
    private CreatePerson createPersonService;

    @Autowired
    private DeletePerson deletePersonService;

    @Autowired
    private GetAllPersons retrievePersonService;

    @Autowired
    private UpdatePerson updatePersonService;

    @PostMapping
    public ResponseEntity createPerson(@RequestBody PersonDTO person){
        createPersonService.createPerson(person);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updatePerson(@RequestBody PersonDTO person, @PathVariable("id") Long id){
        updatePersonService.update(person, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllPerson(){
        return new ResponseEntity(retrievePersonService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Long id){
        deletePersonService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
