package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public DashboardController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }


    @RequestMapping("/index")
    public String dashboard(Model model){
        model.addAttribute("sumQuantities", donationRepository.sumQuantities());
        model.addAttribute("sumDonations", donationRepository.sumDonations());
        return "dashboard/index";
    }


    @ModelAttribute("institutions")
    public List<Institution> institutions(){
        return institutionRepository.findAll();
    }
}
