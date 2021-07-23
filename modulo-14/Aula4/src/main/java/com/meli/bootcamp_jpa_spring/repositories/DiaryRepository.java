package com.meli.bootcamp_jpa_spring.repositories;

import com.meli.bootcamp_jpa_spring.entities.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {
    List<Diary> findDiaryByDentistId(Long id);
}
