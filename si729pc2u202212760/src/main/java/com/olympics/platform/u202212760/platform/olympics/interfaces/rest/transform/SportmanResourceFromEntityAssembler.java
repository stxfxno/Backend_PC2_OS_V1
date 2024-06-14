package com.olympics.platform.u202212760.platform.olympics.interfaces.rest.transform;

import com.olympics.platform.u202212760.platform.olympics.domain.model.aggregates.Sportsman;
import com.olympics.platform.u202212760.platform.olympics.interfaces.rest.resources.SportmanResource;

public class SportmanResourceFromEntityAssembler{
    public static SportmanResource toResourceFromEntity(Sportsman sportman) {
        return new SportmanResource(
                /*
                *   Long id,
                    String name,
                    Long athleticDisciplineId,
                    String country,
                    Date year
                * */

                sportman.getId(),
                sportman.getName(),
                sportman.getAthleticDisciplineId().athleticDisciplineId(),
                sportman.getCountry(),
                sportman.getYear()
        );
    }

}
