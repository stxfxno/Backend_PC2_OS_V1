package com.olympics.platform.u202212760.platform.olympics.infraestructure.persistence.jpa.repository;

import com.olympics.platform.u202212760.platform.olympics.domain.model.aggregates.Sportsman;
import com.olympics.platform.u202212760.platform.olympics.domain.model.valueobjects.AthleticDisciplineId;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SportmanRepository extends JpaRepository<Sportsman, Long> {
    Optional<Sportsman> findByAthleticDisciplineIdAndName(AthleticDisciplineId athleticDisciplineId, @NotBlank String name);

    boolean existsByAthleticDisciplineIdAndName(AthleticDisciplineId athleticDisciplineId, String name);
}
