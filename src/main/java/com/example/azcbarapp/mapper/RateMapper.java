package com.example.azcbarapp.mapper;



import com.example.azcbarapp.client.model.ValCurs;
import com.example.azcbarapp.client.model.Valute;
import com.example.azcbarapp.dao.entity.RateEntity;
import com.example.azcbarapp.model.dto.RateResponseDto;
import com.example.azcbarapp.model.enums.Type;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RateMapper {


    public static RateResponseDto mapEntityToResponseDto(RateEntity rateEntity) {
        return RateResponseDto.builder()
                .nominal(rateEntity.getNominal())
                .name(rateEntity.getName())
                .code(rateEntity.getCode())
                .value(rateEntity.getValue())
                .build();
    }


    public static List<RateResponseDto> mapEntitiesToListResponseDtos(List<RateEntity> rateEntities) {
        return rateEntities.stream()
                .map(RateMapper::mapEntityToResponseDto)
                .collect(Collectors.toList());
    }


    public static List<RateEntity> mapValCursToListRateEntities(ValCurs valCurs) {
        LocalDate cbarDate = valCurs.getDate();
        List<Valute> metals = valCurs.getValType().get(0).getValute();
        List<Valute> currencies = valCurs.getValType().get(1).getValute();

        List<RateEntity> rates = new ArrayList<>();

        for (Valute metal : metals) {
            RateEntity rate = buildRateEntity(metal, Type.PRECIOUS_METAL, cbarDate);
            rates.add(rate);
        }
        for (Valute currency : currencies) {
            RateEntity rate = buildRateEntity(currency, Type.FOREIGN_CURRENCY, cbarDate);
            rates.add(rate);
        }

        return rates;
    }

    private static RateEntity buildRateEntity(Valute valute, Type type, LocalDate date) {
        return RateEntity.builder()
                .name(valute.getName())
                .code(valute.getCode())
                .nominal(valute.getNominal())
                .date(date)
                .type(type)
                .value(valute.getValue())
                .build();
    }


}

    


