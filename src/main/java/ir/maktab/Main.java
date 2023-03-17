package ir.maktab;

import ir.maktab.entity.Person;
import ir.maktab.service.PersonService;


public class Main {
    public static void main(String[] args) throws Exception {
        PersonService personService=new PersonService();
        Person person = new Person(1, "ali", "sedghi");
        Person person1 = new Person(2, "arman", "zanbili");
        // personRepository. save(person);
       //  personRepository.  save(person1);
         personService.load(1);

    }

}