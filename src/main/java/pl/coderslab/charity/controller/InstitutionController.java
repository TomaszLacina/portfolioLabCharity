package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/institution")
public class InstitutionController {

    private final InstitutionRepository institutionRepository;

    public InstitutionController(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/all")
    public String showAllLogins(Model model) {
        model.addAttribute("institution", institutionRepository.findAll());
        return "admin/institution/all";
    }

    @GetMapping("/add")
    public String prepareAdd(Model model) {
        model.addAttribute("institution", new Institution());
        return "admin/institution/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("institution") @Valid Institution institution, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/institution/add";
        }
        institutionRepository.save(institution);
        return "redirect:/admin/institution/all";
    }

    @GetMapping("/edit")
    public String prepareEdit(@RequestParam long idToEdit, Model model) {
        model.addAttribute("institution", institutionRepository.getById(idToEdit));
        return "admin/institution/add";
    }

    @PostMapping("/edit")
    public String merge(@ModelAttribute("institution") @Valid Institution institution, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/institution/add";
        }
        institutionRepository.save(institution);
        return "redirect:/admin/institution/all";
    }

    @GetMapping("/remove")
    public String prepareRemove(@RequestParam long toRemoveId, Model model) {
        model.addAttribute("institution", institutionRepository.getById(toRemoveId));
        institutionRepository.deleteById(toRemoveId);
        return "redirect:/admin/institution/all";
    }



}
