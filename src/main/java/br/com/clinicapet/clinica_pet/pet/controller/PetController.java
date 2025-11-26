package br.com.clinicapet.clinica_pet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

    @GetMapping("/teste")
    public String teste() {
        return "API funcionando!";
    }
}
