package com.example.azcbarapp.dao.repository;

import com.example.azcbarapp.dao.entity.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface RateRepository extends JpaRepository<RateEntity, Long>, JpaSpecificationExecutor<RateEntity> {

    List<RateEntity> findAllByDate(LocalDate date);

    void deleteAllByDate(LocalDate date);

}
