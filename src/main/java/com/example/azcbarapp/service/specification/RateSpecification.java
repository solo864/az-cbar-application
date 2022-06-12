package com.example.azcbarapp.service.specification;


import com.example.azcbarapp.dao.entity.RateEntity;
import com.example.azcbarapp.model.criteria.RateCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RateSpecification implements Specification<RateEntity> {

    private RateCriteria rateCriteria;

    private static final String CURRENCY = "code";
    private static final String DATE = "date";

    public RateSpecification(RateCriteria rateCriteria) {
        this.rateCriteria = rateCriteria;
    }

    @Override
    public Predicate toPredicate(Root<RateEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (rateCriteria != null) {
            if (rateCriteria.getCurrency() != null) {
                predicates.add(criteriaBuilder.equal(root.get(CURRENCY),
                        rateCriteria.getCurrency()));
            }
            if (rateCriteria.getDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get(DATE),
                        LocalDate.parse(rateCriteria.getDate())));
            }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
