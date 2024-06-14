package com.olympics.platform.u202212760.platform.olympics.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record AthleticDisciplineId(Long athleticDisciplineId) {
    public AthleticDisciplineId {
        if (athleticDisciplineId < 0) {
            throw new IllegalArgumentException("Athletic discipline id cannot be less than 0");
        }
    }

    public AthleticDisciplineId() {
        this(0L);
    }


}
