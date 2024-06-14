package com.olympics.platform.u202212760.platform.olympics.interfaces.rest.resources;

import java.util.Date;

public record CreateSportResource(
        String name,
        Long athleticDisciplineId,
        String country,
        Date year
) {
}
