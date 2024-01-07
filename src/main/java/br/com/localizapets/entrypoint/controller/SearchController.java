package br.com.localizapets.entrypoint.controller;

import br.com.localizapets.commons.DataModelResponse;
import br.com.localizapets.entrypoint.controller.exceptions.response.LocationPetResponse;
import br.com.localizapets.entrypoint.mapper.LocationMapper;
import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.usecase.LocationUseCase;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/localizapets/v1")
@Slf4j
public class SearchController {

    private LocationUseCase locationUseCase;


    @GetMapping("/localizacoes")
    public ResponseEntity<DataModelResponse<LocationPetResponse>> consultLocation(@Validated LocationModelRequest locationModelRequest) {
        log.info("BEGIN -SearchController.consultLocation");
        var locationPet = LocationMapper.mapToDomain(locationModelRequest);
        var locationPetResponse = locationUseCase.searchLocation(locationPet);
        var locationPetModelResponse = LocationMapper.mapToModel(locationPetResponse);
        log.info("END -SearchController.consultLocation");
        return ResponseEntity.ok(new DataModelResponse<>(locationPetModelResponse));
    }

}
