package com.olympics.platform.u202212760.platform.olympics.domain.model.aggregates;

import com.olympics.platform.u202212760.platform.olympics.domain.model.commands.CreateSportmanCommand;
import com.olympics.platform.u202212760.platform.olympics.domain.model.valueobjects.AthleticDisciplineId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Getter
public class Sportsman  {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Embedded
    @Column(nullable = false, name = "athleticDiscipline_id")
    private final AthleticDisciplineId athleticDisciplineId;

    @NotBlank
    @Column(nullable = false)
    private String country;

    @Temporal(TemporalType.DATE)
    private java.sql.Date year;

    /**
     * Constructor for the Sportsman with command parameter
     *
     * @param command
     */

    public Sportsman(CreateSportmanCommand command ){
        this.name = command.name();
        this.athleticDisciplineId = new AthleticDisciplineId(command.athleticDisciplineId());
        this.country = command.country();
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, Integer.parseInt(String.valueOf(command.year())));cal.set(Calendar.DAY_OF_YEAR, 1); // Optional: set the date to the first day of the year
            this.year = new java.sql.Date(cal.getTimeInMillis());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public Sportsman(){
        this.name = Strings.EMPTY;
        this.athleticDisciplineId = new AthleticDisciplineId();
        this.country = Strings.EMPTY;
        this.year = new Date(0);
    }

    public Sportsman(AthleticDisciplineId athleticDisciplinedId){
        this.athleticDisciplineId = athleticDisciplinedId;
    }

}