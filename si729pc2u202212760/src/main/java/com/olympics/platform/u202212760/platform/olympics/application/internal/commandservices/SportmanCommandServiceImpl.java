package com.olympics.platform.u202212760.platform.olympics.application.internal.commandservices;

import com.olympics.platform.u202212760.platform.olympics.domain.model.aggregates.Sportsman;
import com.olympics.platform.u202212760.platform.olympics.domain.model.commands.CreateSportmanCommand;
import com.olympics.platform.u202212760.platform.olympics.domain.services.SportmanCommandService;
import com.olympics.platform.u202212760.platform.olympics.infraestructure.persistence.jpa.repository.SportmanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SportmanCommandServiceImpl implements SportmanCommandService {

    private final SportmanRepository sportmanRepository;

    public SportmanCommandServiceImpl(SportmanRepository sportmanRepository) {
        this.sportmanRepository = sportmanRepository;
    }

    //en base al sportman repository
    @Override
    public Optional<Sportsman> handle(CreateSportmanCommand command) {
        try {
            var sportsman = new Sportsman(command);
            if (sportmanRepository.existsByAthleticDisciplineIdAndName(sportsman.getAthleticDisciplineId(), sportsman.getName())){
                throw new IllegalArgumentException("Sportsman already exists in this discipline");
            }
            sportmanRepository.save(sportsman);
            return Optional.of(sportsman);
        }
        catch (Exception e) {
            return Optional.empty();
        }
    }
}
