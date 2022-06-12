package com.example.azcbarapp.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RateResponseDto {

    private String nominal;
    private String name;
    private String code;
    private BigDecimal value;

}
