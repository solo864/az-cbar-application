package com.example.azcbarapp.controller;

import com.example.azcbarapp.model.criteria.PageCriteria;
import com.example.azcbarapp.model.criteria.RateCriteria;
import com.example.azcbarapp.model.dto.PageableRateDto;
import com.example.azcbarapp.service.RateService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequiredArgsConstructor
@RequestMapping("v1/rates")
public class RateController {

    private final RateService rateService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void save(LocalDate date) {
        rateService.save(date);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRateByDate(LocalDate date) {
        rateService.deleteByDate(date);
    }

    @GetMapping
    public PageableRateDto getRates(RateCriteria rateCriteria, PageCriteria pageCriteria) {
        return rateService.getRates(rateCriteria, pageCriteria);
    }


}

