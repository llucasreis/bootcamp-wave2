package com.meli.bootcamp_jpa_spring.controllers;

import com.meli.bootcamp_jpa_spring.entities.Diary;
import com.meli.bootcamp_jpa_spring.repositories.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("diaries/")
public class DiaryController {

    private DiaryRepository diaryRepository;

    @Autowired
    public DiaryController(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @GetMapping("{dentistId}")
    public void findDiaryByDentist(@PathVariable Long dentistId){
        List<Diary> diaries = diaryRepository.findDiaryByDentistId(dentistId);
        System.out.println(diaries);
    }
}
