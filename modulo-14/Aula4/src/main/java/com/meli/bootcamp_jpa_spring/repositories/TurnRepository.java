package com.meli.bootcamp_jpa_spring.repositories;

import com.meli.bootcamp_jpa_spring.entities.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TurnRepository extends JpaRepository<Turn, Long> {
    List<Turn> findByTurnStatusId(Long id);
    List<Turn> findByTurnStatusIdAndDay(Long id, LocalDate localDate);
    List<Turn> findTurnByTurnStatusIdAndDiary_DentistId(Long statusId, Long dentistId);
}
