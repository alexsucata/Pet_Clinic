package com.alexsucata.consults;

import java.util.List;

public interface ConsultRepository {

    void create(ConsultEntity consult);

    ConsultEntity findById(Integer consultId);

    List<ConsultEntity> findAll();

    void update(Integer consultId, ConsultEntity consult);

    void delete(ConsultEntity consultId);

}
