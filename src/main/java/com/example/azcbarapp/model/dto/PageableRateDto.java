package com.example.azcbarapp.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageableRateDto {

    private List<RateResponseDto> rates;
    private int lastPageNumber;
    private boolean hasNextPage;

}
