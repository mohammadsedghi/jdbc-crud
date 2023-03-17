package ir.maktab;

import ir.maktab.entity.Person;
import ir.maktab.personreposiitory.JdbcConnection;
import ir.maktab.personreposiitory.PersonRepository;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        PersonRepository personRepository=new PersonRepository();
        Person person = new Person(1, "ali", "sedghi");
        Person person1 = new Person(2, "arman", "zanbili");
        // personRepository. save(person);
       //  personRepository.  save(person1);
         personRepository.select(person);

    }

}