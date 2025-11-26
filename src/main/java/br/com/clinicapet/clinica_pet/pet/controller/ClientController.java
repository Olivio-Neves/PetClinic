package br.com.clinicapet.clinica_pet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/")
    public String home() {
        return "API da Clínica Pet funcionando!";
    }
}
