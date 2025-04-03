package webapp.application.alishevprojects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello-world")
    public String seyHello(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "surname", required = false) String surname,
                           Model model){

        String message = "Hello, " + name + " " + surname;
        if(name == null){
            message = "Enter you name and surname";
        }
        if(surname == null){
            message = "Enter you name and surname";
        }

        model.addAttribute("message", message);

        return "/hello_world_page";
    }

    // ?a=10&b=15&move=add
    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a", required = false) int a,
                            @RequestParam(value = "b", required = false) int b,
                            @RequestParam(value = "move", required = false) String move,
                            Model model){
        double res = 0;
        switch (move){
            case "mult":{
                res = a * b;
                break;
            }
            case "add":{
                res = a + b;
                break;
            }
            case "sub":{
                res = a - b;
                break;
            }
            case "div":{
                res = (double) a / b;
                break;
            }
        }
        model.addAttribute("result", res);
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("move", move);
        return "/calculate";
    }

    @GetMapping("/goodbye")
    public String seyGoodBuy(){
        return "/good-buy-page";
    }
}
