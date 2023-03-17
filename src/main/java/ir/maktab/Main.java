package ir.maktab;

import ir.maktab.entity.Person;
import ir.maktab.personreposiitory.PersonRepository;
import ir.maktab.service.PersonService;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws Exception {
        PersonService personService=new PersonService();
        PersonRepository personRepository = new PersonRepository();
        Person person = new Person(1, "ali", "sedghi");
        Person person1 = new Person(2, "arman", "zanbili");
        Person person2 = new Person(9, "amir", "nakhei");
        // personRepository. save(person);
       //  personRepository.  save(person1);
//         personService.load(1);
//        Person[]persons =new Person[2];
//        persons[0]=person;
//        persons[1]=person1;
//        personRepository.saveAll(persons);
//        System.out.println(Arrays.toString(personRepository.loadAll()) );
        System.out.println(personRepository.save1(person2));


    }

}