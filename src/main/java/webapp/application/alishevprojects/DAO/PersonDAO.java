package webapp.application.alishevprojects.DAO;

import org.springframework.stereotype.Component;
import webapp.application.alishevprojects.Person.Person;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final List<Person> personList;
    {
        personList = new ArrayList<>();
        personList.add(new Person(1,"tadoHopsky", 25, "123-123"));
        personList.add(new Person(2,"kskessa", 27, "123-123"));
        personList.add(new Person(3,"egor228", 23, "123-123"));
        personList.add(new Person(4,"Ilya", 32, "123-123"));
    }

    public List<Person> index(){
        return personList;
    }

    public Person show(int id){
        return personList.stream().filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }
}
