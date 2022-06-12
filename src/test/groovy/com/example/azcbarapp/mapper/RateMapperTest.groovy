package com.example.azcbarapp.mapper

import com.example.azcbarapp.dao.entity.RateEntity
import io.github.benas.randombeans.EnhancedRandomBuilder
import spock.lang.Specification

class RateMapperTest extends Specification {

    private random = EnhancedRandomBuilder.aNewEnhancedRandom()


    def "map Entity to Response Dto test"() {
        given:
        def entity = random.nextObject(RateEntity)
        when:
        def result = RateMapper.mapEntityToResponseDto(entity)
        then:
        result.nominal == entity.nominal
        result.name == entity.name
        result.code == entity.code
        result.value == entity.value
    }

    def 'map Entities to Response Dtos test'() {
        given:
        def entities = random.nextObject(List<com.example.azcbarapp.dao.entity.RateEntity>)
        when:
        def result = RateMapper.mapEntitiesToListResponseDtos(entities)
        then:
        for (int i = 0; i < result.size(); i++) {
            result.get(i).nominal = entities.get(i).nominal;
            result.get(i).name = entities.get(i).name;
            result.get(i).code = entities.get(i).code;
            result.get(i).value = entities.get(i).value;
        }
    }

}
