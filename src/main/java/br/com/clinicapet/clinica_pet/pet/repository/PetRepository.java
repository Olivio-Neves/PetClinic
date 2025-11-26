package br.com.clinicapet.clinica_pet.pet.repository;

import br.com.clinicapet.clinica_pet.pet.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
