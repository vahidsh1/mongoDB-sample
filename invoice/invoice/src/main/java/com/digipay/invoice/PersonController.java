package com.digipay.invoice;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class PersonController {
    @Autowired
    MongoTemplate mongoTemplate;
//    @Autowired
//    Person person;
    @Autowired
    private PersonRepository personRepository;

    //    private UserRepository userRepository;
    @GetMapping
    public void savePerson() throws JsonProcessingException {
        Person person = new Person();
        person.setId("vahid");
        mongoTemplate.save(person);
        User user = new User();
        user.setAge(2);
        mongoTemplate.save(user);
    }

}
