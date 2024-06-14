package com.olympics.platform.u202212760.platform.olympics.domain.services;

import com.olympics.platform.u202212760.platform.olympics.domain.model.aggregates.Sportsman;
import com.olympics.platform.u202212760.platform.olympics.domain.model.commands.CreateSportmanCommand;

import java.util.Optional;

public interface SportmanCommandService {
    Optional<Sportsman> handle(CreateSportmanCommand command);

}
