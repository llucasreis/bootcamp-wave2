package com.meli.bootcamp_jpa_spring.repositories;

import com.meli.bootcamp_jpa_spring.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DentistRepository extends JpaRepository<Dentist, Long> {

    @Query(value = "select de from Dentist de inner join Diary di on(de.id = di.dentist) inner join Turn t on(t.diary = di.id) group by de.id, t.day having count(t.id) > 2")
    List<Dentist> listDentistsWithMoreThan2TurnsInADay();

}
