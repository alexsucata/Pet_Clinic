package com.alexsucata.owners;

import java.util.List;

public interface OwnerRepository {

    void create(OwnerEntity owner);

    OwnerEntity findById(Integer ownerId);

    List<OwnerEntity> findAll();

    void update(Integer ownerId, OwnerEntity owner);

    void delete(OwnerEntity ownerId);


}
