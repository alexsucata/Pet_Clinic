package com.alexsucata.veterinarians;

import java.util.List;

public interface VeterinarianRepository {

    void create(VeterinarianEntity veterinarian);

    VeterinarianEntity findById(Integer veterinarianId);

    List<VeterinarianEntity> findAll();

    void update(VeterinarianEntity oldVeterinarian, VeterinarianEntity newVeterinarian);

    void delete(Integer veterinarianId);

}
