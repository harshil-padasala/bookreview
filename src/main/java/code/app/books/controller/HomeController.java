package code.app.books.controller;

import code.app.books.beans.User;
import code.app.books.database.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private DatabaseAccess databaseAccess;

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "login";
    }

    @GetMapping("access-denied")
    public String showAccessDenied() {
        return "error/permission-denied";
    }

    @GetMapping("/registerUser")
    public String showRegisterUserPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute User user) {
        databaseAccess.addUser(user);
        return "login";
    }
}
