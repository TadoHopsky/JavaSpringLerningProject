package webapp.application.alishevprojects.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    private int id;
    private String userName;
    private int age;
    private String zip;

    @Override
    public String toString() {
        return "Track{" +
                "id: " + id + "," +
                "user name: " + userName + "," +
                "age: " + age + "," +
                "zip-code: " + zip + ",";
    }
}
