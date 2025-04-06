package webapp.application.alishevprojects.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import webapp.application.alishevprojects.DAO.PersonDAO;

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
}
