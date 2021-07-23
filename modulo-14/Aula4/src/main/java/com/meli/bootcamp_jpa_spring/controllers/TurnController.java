package com.meli.bootcamp_jpa_spring.controllers;

import com.meli.bootcamp_jpa_spring.entities.Turn;
import com.meli.bootcamp_jpa_spring.repositories.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("turns/")
public class TurnController {

    private TurnRepository turnRepository;

    @Autowired
    public TurnController(TurnRepository turnRepository) {
        this.turnRepository = turnRepository;
    }

    @GetMapping("finished")
    public void findTurnFinished(){
        List<Turn> turns = turnRepository.findByTurnStatusId(1L);
        System.out.println(turns);
    }

    @GetMapping("pending/{day}")
    public void findTurnFinished(@PathVariable String day){
        List<Turn> turns = turnRepository.findByTurnStatusIdAndDay(2L, LocalDate.parse(day));
        System.out.println(turns);
    }

    @GetMapping("rescheduled/{idDentist}")
    public void findTurnRescheduledByDentist(@PathVariable Long idDentist){
        List<Turn> turns = turnRepository.findTurnByTurnStatusIdAndDiary_DentistId(3L, idDentist);
        System.out.println(turns);
    }
}
