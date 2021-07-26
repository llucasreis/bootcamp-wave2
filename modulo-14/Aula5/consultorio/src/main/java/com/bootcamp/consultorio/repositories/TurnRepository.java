package com.bootcamp.consultorio.repositories;

import com.bootcamp.consultorio.domain.Turn;
import com.bootcamp.consultorio.domain.TurnStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TurnRepository extends MongoRepository<Turn, String> {

    List<Turn> findByDoctorLastName(String lastName);
    List<Turn> findByStatus(TurnStatus turnStatus);
}
