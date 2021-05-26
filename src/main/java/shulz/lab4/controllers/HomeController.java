package shulz.lab4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String hello(Model uiModel) {
        uiModel.addAttribute("name", "World!");
        return "index";
    }

    @RequestMapping(value = "/start/{name}", method = RequestMethod.GET)
    public String hello(Model uiModel, @PathVariable(value = "name") String name) {
        uiModel.addAttribute("name", name);
        return "index";
    }

}
