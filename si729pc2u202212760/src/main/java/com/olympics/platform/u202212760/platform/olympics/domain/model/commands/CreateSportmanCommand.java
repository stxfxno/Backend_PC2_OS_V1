package com.olympics.platform.u202212760.platform.olympics.domain.model.commands;

import java.util.Date;

public record CreateSportmanCommand(
        String name,
        Long athleticDisciplineId,
        String country,
        String year
) {

}
