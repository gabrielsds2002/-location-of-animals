package br.com.localizapets.entrypoint.controller;

import br.com.localizapets.commons.DataModelMapper;
import br.com.localizapets.commons.DataModelResponse;
import br.com.localizapets.dataprovider.repository.LocationPortIn;
import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.entrypoint.model.response.LocationModelResponse;
import br.com.localizapets.usecase.domain.response.LocationPetResponse;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping(value = "/localizapets/v1")
public class SearchController {

    private LocationPortIn locationPortIn;

    private final DataModelMapper dataModelMapper;

    @GetMapping("/localizacoes")
    public ResponseEntity<DataModelResponse<LocationModelResponse>> consultLocation(@Validated LocationModelRequest locationModelRequest) {
        LocationPetResponse localizacaoModelResponse =  locationPortIn.searchLocation(locationModelRequest);
        DataModelResponse dataModelResponse = dataModelMapper.setDataModel(localizacaoModelResponse);
        return ResponseEntity.ok(dataModelResponse);
    }

}
