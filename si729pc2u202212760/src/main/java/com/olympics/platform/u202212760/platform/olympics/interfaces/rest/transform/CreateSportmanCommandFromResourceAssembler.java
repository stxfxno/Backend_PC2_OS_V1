package com.olympics.platform.u202212760.platform.olympics.interfaces.rest.transform;

import com.olympics.platform.u202212760.platform.olympics.domain.model.commands.CreateSportmanCommand;
import com.olympics.platform.u202212760.platform.olympics.interfaces.rest.resources.CreateSportResource;

import java.text.SimpleDateFormat;

public class CreateSportmanCommandFromResourceAssembler{
    public static CreateSportmanCommand toCommandFromResource(CreateSportResource sportmanResource) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String yearAsString = sdf.format(sportmanResource.year());
        return new CreateSportmanCommand(
                sportmanResource.name(),
                sportmanResource.athleticDisciplineId(),
                sportmanResource.country(),
                yearAsString
        );
    }
}