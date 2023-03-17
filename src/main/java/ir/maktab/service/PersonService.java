package ir.maktab.service;
import ir.maktab.personreposiitory.PersonRepository;
import ir.maktab.entity.Person;



import java.util.Objects;
import java.util.regex.Pattern;

public class PersonService {

    private final PersonRepository personRepository = new PersonRepository();

    public void save(Person person) throws Exception {
        if (Pattern.matches("[A-Z][a-z]*",person.getName()) && Pattern.matches("[A-Z][a-z]*",person.getFamily()) ){
            personRepository.save(person);
        }else {
            System.out.println("your first character of your firstname and lastname should contain an uppercase and other character of your firstname and lastname should be lowercase");
        }
    }

    public void update(Person person , String firstname , String lastname) throws Exception{
        if (!Objects.equals(person.getName() , firstname) ){
            System.out.println("test");
            if (Pattern.matches("[A-Z][a-z]*",firstname)){
                System.out.println("test1");
                person.setName(firstname);
                personRepository.update(person);
            }else {
                System.out.println("your first character of your firstname should contain an uppercase and other character of your firstname should be lowercase");
            }

        }else {
            System.out.println("Your new firstname is the same as the previous one");
        }
        if (!Objects.equals(person.getFamily() , lastname)){
            System.out.println("test2");
            if (Pattern.matches("[A-Z][a-z]*",lastname) ){
                System.out.println("test3");
                person.setFamily(lastname);
                personRepository.update(person);
            }else {
                System.out.println("your first character of your lastname should contain an uppercase and other character of your lastname should be lowercase");
            }
        }else {
            System.out.println("Your new lastname is the same as the previous one");
        }
    }

    public void delete(int personId) throws Exception{

        if (personRepository.load(personId) == null){
            System.out.println("Id is not exist");
        }else {
            personRepository.delete(personId);
            System.out.println("Id is deleted");
        }

    }

    public Person load(int personId) throws Exception{
        if (personRepository.load(personId) == null){
            System.out.println("Id is not exist");
        }else {
            System.out.println("Id is Loaded");
            return personRepository.load(personId);
        }
        return null;
    }


}
