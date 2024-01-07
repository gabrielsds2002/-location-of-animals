package br.com.localizapets.entrypoint.mapper;

import br.com.localizapets.entrypoint.controller.exceptions.response.LocationPetResponse;
import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.entrypoint.model.response.LocationModelResponse;
import br.com.localizapets.usecase.domain.LocationPet;

public class LocationMapper {

    public static LocationPet mapToDomain(LocationModelRequest locationModelRequest) {
        return LocationPet.builder()
                .latitude(locationModelRequest.getLatitude())
                .longitude(locationModelRequest.getLongitude())
                .idColeira(locationModelRequest.getIdColeira())
                .build();
    }

    public static LocationPetResponse mapToModel(LocationPet localizacaoResponse) {
        return LocationPetResponse.builder()
                .country(localizacaoResponse.getCountry())
                .county(localizacaoResponse.getCounty())
                .region(localizacaoResponse.getRegion())
                .neighbourhood(localizacaoResponse.getNeighbourhood())
                .name(localizacaoResponse.getName())
                .build();
    }
}
