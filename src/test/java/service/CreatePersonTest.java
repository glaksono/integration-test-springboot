package service;

import configuration.DatabaseConfiguration;
import glaksono.springboot.model.PersonDTO;
import glaksono.springboot.service.CreatePerson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableJpaRepositories(basePackages = "glaksono.springboot.repository")
@ComponentScan(basePackages = "glaksono.springboot")
@ContextConfiguration(classes = DatabaseConfiguration.class)
public class CreatePersonTest {

    @Autowired
    private CreatePerson createPersonService;

    @Test
    public void createPersonTest(){
        PersonDTO person = new PersonDTO();
        person.setName("testPerson");
        person.setPhoneNo("081112233445");
        createPersonService.createPerson(person);
    }
}
