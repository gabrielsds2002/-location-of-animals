package br.com.locationpets.entrypoint.mapper;

import br.com.locationpets.entrypoint.model.request.LocationModelRequest;
import br.com.locationpets.entrypoint.model.response.LocationModelResponse;
import br.com.locationpets.usecase.domain.LocationPet;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationMapper {

    public static LocationPet mapToDomain(LocationModelRequest locationModelRequest) {
        return LocationPet.builder()
                .latitude(locationModelRequest.getLatitude())
                .longitude(locationModelRequest.getLongitude())
                .idCollar(locationModelRequest.getIdCollar())
                .build();
    }

    public static LocationModelResponse mapToModel(LocationPet localizacaoResponse) {
        return LocationModelResponse.builder()
                .country(localizacaoResponse.getCountry())
                .county(localizacaoResponse.getCounty())
                .region(localizacaoResponse.getRegion())
                .neighbourhood(localizacaoResponse.getNeighbourhood())
                .name(localizacaoResponse.getName())
                .build();
    }
}
