package com.olympics.platform.u202212760.platform.olympics.interfaces.rest;


import com.olympics.platform.u202212760.platform.olympics.domain.services.SportmanCommandService;
import com.olympics.platform.u202212760.platform.olympics.interfaces.rest.resources.CreateSportResource;
import com.olympics.platform.u202212760.platform.olympics.interfaces.rest.resources.SportmanResource;
import com.olympics.platform.u202212760.platform.olympics.interfaces.rest.transform.CreateSportmanCommandFromResourceAssembler;
import com.olympics.platform.u202212760.platform.olympics.interfaces.rest.transform.SportmanResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/sportsman", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Sportsman", description = "Sportsman Management Endpoints")

public class SportmanController {

    private final SportmanCommandService sportmanCommandService;

    private static final Logger logger = LoggerFactory.getLogger(SportmanController.class);


    public SportmanController(SportmanCommandService sportmanCommandService) {
        this.sportmanCommandService = sportmanCommandService;
    }

    @Operation(summary="Create a new Sportman", description="Create a new Sportman with the input data.")
    @PostMapping
    public ResponseEntity<SportmanResource> createSportman(@RequestBody CreateSportResource resource){
        try{
            var createSportmanCommand = CreateSportmanCommandFromResourceAssembler.toCommandFromResource(resource);
            var agencyOptional = sportmanCommandService.handle(createSportmanCommand);
            if (agencyOptional.isPresent()) {
                var sportmanResource = SportmanResourceFromEntityAssembler.toResourceFromEntity(agencyOptional.get());
                return ResponseEntity.status(HttpStatus.CREATED).body(sportmanResource); //201
            } else {
                // handle the case where the Optional is empty
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //404
            }
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            logger.error("Error while creating sportsman: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); //500
        }
    }
}
