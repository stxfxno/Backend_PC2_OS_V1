package com.olympics.platform.u202212760.platform.olympics.interfaces.rest.resources;

public record SportmanResource(
        Long id,
        String name,
        Long athleticDisciplineId,
        String country,
        java.sql.@jakarta.validation.constraints.NotNull(message = "Year is mandatory") Date year){

}
