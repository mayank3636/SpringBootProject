package cms.project.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cms.project.springboot.dao.userDao;
import cms.project.springboot.model.PersonForm;
import cms.project.springboot.service.UserAddService;


@Controller
public class RegistrationController {
	@Autowired
	userDao user;
@Autowired
UserAddService userService;
@RequestMapping("/registationsucess")
public String sucesspage(){
	return "registationsucess";
}

    @GetMapping("/registration")
    public String showForm(PersonForm personForm) {
        return "registration";
    }

    @PostMapping("/registration")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
                userService.addNewUser(personForm);
        return "redirect:/registationsucess";
    }
}
