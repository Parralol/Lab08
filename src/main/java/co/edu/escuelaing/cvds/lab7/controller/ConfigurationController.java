package co.edu.escuelaing.cvds.lab7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.edu.escuelaing.cvds.lab7.service.ConfigurationService;

@Controller
public class ConfigurationController {

    @Autowired
    ConfigurationService configurationService;

    @GetMapping("/example")
    public String example(Model model) {
        model.addAttribute("premio", configurationService.getPremio());
        return "example";
    }

    
}
