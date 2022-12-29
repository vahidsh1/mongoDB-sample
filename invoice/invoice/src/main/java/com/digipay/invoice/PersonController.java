package com.digipay.invoice;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class PersonController {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    AddressRepository addressRepository;
    //    @Autowired
//    PersonRepository personRepository;
    //    @Autowired
//    Address address;
    //    Person person;
    @Autowired
    private PersonRepository personRepository;
    //    private UserRepository userRepository;
    @GetMapping("/person")
    public void savePerson() throws JsonProcessingException {
        //Method 1
//        Person person = new Person();
//        person.setName("vahid");
//        mongoTemplate.save(person);
//        Address address = new Address();
////        address.setCity("tehran");
////        person.setAddress(address);
//        mongoTemplate.save(person);

        //Method 2

//        Person person = new Person();
//        Address address = new Address();
//        address.setCity("tehran");
//        person.setAddress(address);
//        addressRepository.save(address);
//
//        person.setName("vahid");
//        personRepository.save(person);

//Method 3
        Person person = new Person();
        Address address = new Address();
        address.setCity("tehran");
        person.setAddress(address);
        person.setId("Method 3 ");
        Address savedAddress=addressRepository.save(address);
        person.setAddress(savedAddress);
        personRepository.save(person);

    }
    @GetMapping("/find/{id}")
    public String findAll(@PathVariable String id){

        Query query= new Query(Criteria.where("name").is(id));
//        Update update=new Update();
        List<Person> personList = mongoTemplate.find(query,Person.class);
        System.out.println(personList.get(0));
        return personList.get(1).getAddress().getCity();
    }

}
