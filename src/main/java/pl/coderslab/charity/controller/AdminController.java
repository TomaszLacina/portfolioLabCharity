package pl.coderslab.charity.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Status;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.StatusRepository;
import pl.coderslab.charity.service.UserService;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final DonationRepository donationRepository;
    private final StatusRepository statusRepository;

    public AdminController(UserRepository userRepository, UserService userService, RoleRepository roleRepository, DonationRepository donationRepository, StatusRepository statusRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.donationRepository = donationRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping("/user/all")
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

    @GetMapping("/user/add")
    public String addAdmin(Model model) {
        model.addAttribute("user", new User());
        return "admin/user/add";
    }

    @PostMapping("/user/add")
    public String saveAdmin(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/user/add";
        }
        userService.saveAdmin(user);
        return "redirect:/admin/user/all";
    }

    @GetMapping("/user/edit")
    public String editAdmin(@RequestParam long idToEdit, Model model) {
        model.addAttribute("user", userRepository.findById(idToEdit));
        return "admin/user/edit";
    }

    @PostMapping("/user/edit")
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

    @GetMapping("/user/remove")
    public String removeAdmin(@RequestParam long toRemoveId, Model model) {
        model.addAttribute("user", userRepository.findById(toRemoveId));
        userRepository.deleteById(toRemoveId);
        return "redirect:/admin/user/all";
    }

    @GetMapping("/user/role")
    public String findByRoleId(@RequestParam long idRole, Model model) {
        model.addAttribute("user", userRepository.findAllByRolesId(idRole));
        userRepository.findAllByRolesId(idRole);
        return "admin/user/role";
    }

    @GetMapping("/donation/all")
    public String showAllDonation(Model model) {
        List<Donation> donations = donationRepository.findAll();
        model.addAttribute("donation", donations);
        return "/admin/donation/all";
    }

    @GetMapping("/donation/edit")
    public String editDonation(@RequestParam long idToEdit, Model model) {
        model.addAttribute("donation", donationRepository.findById(idToEdit));
        return "admin/donation/edit";
    }

    @PostMapping("/donation/edit")
    public String mergeDonation(@ModelAttribute("donation") @Valid Donation donation, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/donation/edit";
        }
        donationRepository.save(donation);
        return "redirect:/admin/donation/all";
    }


    @ModelAttribute("roles")
    public List<Role> roles() {return roleRepository.findAll();}

    @ModelAttribute("statuses")
    public List<Status> statuses() {
        return statusRepository.findAll();
    }

}
