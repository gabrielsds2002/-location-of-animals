package br.com.localizapets.entrypoint.controller;

import br.com.localizapets.commons.DataModelResponse;
import br.com.localizapets.dataprovider.dto.LocationPetResponseDto;
import br.com.localizapets.entrypoint.mapper.LocationMapper;
import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.usecase.LocationUseCase;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static net.logstash.logback.marker.Markers.append;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/locationPets/v1")
@Slf4j
public class LocationController {


    private LocationUseCase locationUseCase;

    @GetMapping("/locations")

    public ResponseEntity<DataModelResponse<LocationPetResponseDto>> consultLocation(@Validated LocationModelRequest locationModelRequest) {
        log.info(append("PAYLOAD_REQUEST", locationModelRequest),
                "Starting the query of the pet's location with the request data");
        var locationPet = LocationMapper.mapToDomain(locationModelRequest);
        log.info("Data mapping carried out and starting integration with the location service");
        var locationPetResponse = locationUseCase.searchLocation(locationPet);
        log.info(append("PAYLOAD_DOMAIN", locationPetResponse),
                "Starting the assembly of the output object with the data found on the pet's location");
        var locationPetModelResponse = LocationMapper.mapToModel(locationPetResponse);

        log.info(append("PAYLOAD_RESPONSE", locationPetModelResponse)
                        .and(append("HTTP_STATUS", HttpStatus.OK.value())),
                "Completing the pet location query successfully");

        return ResponseEntity.ok(new DataModelResponse<>(locationPetModelResponse));
    }
}
