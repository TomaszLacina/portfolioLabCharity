package pl.coderslab.charity.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.UserService;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/user")
public class AdminController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final RoleRepository roleRepository;

    public AdminController(UserRepository userRepository, UserService userService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/all")
    public String showAll(Model model,
                          @RequestParam(value = "field", required = false) UserSearchMode field,
                          @RequestParam(value = "query", required = false) String query) {
        if (field != null && StringUtils.isNotEmpty(query)) {
            switch (field) {
                case EMAIL:
                    model.addAttribute("user", userRepository.findByEmail(query));
                    break;
                case USERNAME:
                    model.addAttribute("user", userRepository.findAllByUsername(query));
                    break;
            }
            model.addAttribute("selectedField", field);
        } else {
            model.addAttribute("user", userRepository.findAll());
        }
        model.addAttribute("query", query);
        model.addAttribute("searchMode", UserSearchMode.values());
        return "admin/user/all";
    }

    @GetMapping("/add")
    public String addAdmin(Model model) {
        model.addAttribute("user", new User());
        return "admin/user/add";
    }

    @PostMapping("/add")
    public String saveAdmin(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/user/add";
        }
        userService.saveAdmin(user);
        return "redirect:/admin/user/all";
    }

    @GetMapping("/edit")
    public String editAdmin(@RequestParam long idToEdit, Model model) {
        model.addAttribute("user", userRepository.findById(idToEdit));
        return "admin/user/edit";
    }

    @PostMapping("/edit")
    public String mergeAdmin(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/user/edit";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "redirect:/admin/user/all";
    }

    @GetMapping("/remove")
    public String removeAdmin(@RequestParam long toRemoveId, Model model) {
        model.addAttribute("user", userRepository.findById(toRemoveId));
        userRepository.deleteById(toRemoveId);
        return "redirect:/admin/user/all";
    }

    @GetMapping("/role")
    public String findByRoleId(@RequestParam long idRole, Model model) {
        model.addAttribute("user", userRepository.findAllByRolesId(idRole));
        userRepository.findAllByRolesId(idRole);
        return "admin/user/role";
    }

    @ModelAttribute("roles")
    public List<Role> roles() {return roleRepository.findAll();}
}
