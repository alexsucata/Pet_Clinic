package com.alexsucata.pets;

import java.util.List;

public interface PetRepository {

    void create(PetEntity pet);

    PetEntity findById(Integer petId);

    List<PetEntity> findAll();

    void update(PetEntity petId, PetEntity pet);

    void delete(Integer petId);

}
