package webapp.application.alishevprojects.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.application.alishevprojects.DAO.PersonDAO;
import webapp.application.alishevprojects.Person.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String getAllUsers(Model model){
        model.addAttribute("people", personDAO.index());
        return "allUsers";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,
                       Model model){
        model.addAttribute("person", personDAO.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute(new Person());
        return "new";
    }

    @PostMapping
    public String createNewPerson(@ModelAttribute("person") Person person){
        personDAO.save(person);
        return "redirect:/people";
    }
}
