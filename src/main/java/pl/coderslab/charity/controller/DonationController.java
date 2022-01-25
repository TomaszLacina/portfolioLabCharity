package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.CurrentUser;
import pl.coderslab.charity.entity.*;
import pl.coderslab.charity.repository.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/user/donation")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;
    private final UserRepository userRepository;
    private final StatusRepository statusRepository;

    public DonationController(CategoryRepository categoryRepository, DonationRepository donationRepository, InstitutionRepository institutionRepository, UserRepository userRepository, StatusRepository statusRepository) {
        this.categoryRepository = categoryRepository;
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
        this.userRepository = userRepository;
        this.statusRepository = statusRepository;
    }
    @GetMapping("/all")
    public String showAllDonation(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        List<Donation> donations = donationRepository.findAllByUser(customUser.getUser());
        model.addAttribute("donation", donations);
        return "/user/donation/all";
    }

    @GetMapping("/add")
    public String addDonation(Model model, @AuthenticationPrincipal CurrentUser customUser){
        model.addAttribute("donation", new Donation());
        return "/user/donation/add";
    }

    @PostMapping("/add")
    public String saveDonation(@ModelAttribute("donation") @Valid Donation donation, BindingResult result, @AuthenticationPrincipal CurrentUser customUser){

        if(result.hasErrors()){
            return "/user/donation/add";
        }
        Status status = statusRepository.findByName("Nieodebrane");
        donation.setStatuses(new HashSet<>(Arrays.asList(status)));
        User entityUser = customUser.getUser();
        donation.setUser(entityUser);
        donationRepository.save(donation);
        return "redirect:/dashboard/index";
    }

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryRepository.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions(){
        return institutionRepository.findAll();
    }

    @ModelAttribute("user")
    public List<User> user() {
        return userRepository.findAll();
    }

    @ModelAttribute("statuses")
    public List<Status> statuses() {
        return statusRepository.findAll();
    }
}
