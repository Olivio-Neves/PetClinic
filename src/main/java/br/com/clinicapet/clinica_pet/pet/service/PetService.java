package br.com.clinicapet.clinica_pet.pet.service;

import br.com.clinicapet.clinica_pet.pet.model.Pet;
import br.com.clinicapet.clinica_pet.pet.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public Pet salvar(Pet pet) {
        return petRepository.save(pet);
    }

    public List<Pet> listar() {
        return petRepository.findAll();
    }

    public Pet buscar(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        petRepository.deleteById(id);
    }
}
