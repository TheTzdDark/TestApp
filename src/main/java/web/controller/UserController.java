package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String printAll(Model model) {
        model.addAttribute("users", service.getAll());
        return "users/index";
    }

    @GetMapping("/new")
    public String printAddForm(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user) {
        service.save(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String remove(@RequestParam("id") long id) {
        service.removeById(id);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String printEditForm(@RequestParam("id") long id, Model model) {
        model.addAttribute("user", service.getById(id));
        return "users/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("user") User user, @RequestParam("id") long id) {
        service.update(user, id);
        return "redirect:/users";
    }
}
