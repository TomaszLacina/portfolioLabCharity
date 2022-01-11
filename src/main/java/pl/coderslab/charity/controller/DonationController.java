package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;

    public DonationController(CategoryRepository categoryRepository, DonationRepository donationRepository, InstitutionRepository institutionRepository) {
        this.categoryRepository = categoryRepository;
        this.donationRepository = donationRepository;
        this.institutionRepository = institutionRepository;
    }


    @GetMapping("/add")
    public String addDonation(Model model){
        model.addAttribute("donation", new Donation());

        return "/donation/add";
    }
    @PostMapping("/add")
    public String addDonationPost(@ModelAttribute("donation") @Valid Donation donation, BindingResult result){
        if(result.hasErrors()) {
            return "/donation/add";
        }
        donationRepository.save(donation);
        return "redirect:/donation/add";
    }


    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryRepository.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions(){
        return institutionRepository.findAll();
    }

}
