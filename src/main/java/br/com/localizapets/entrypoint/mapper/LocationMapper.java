package br.com.localizapets.entrypoint.mapper;

import br.com.localizapets.dataprovider.dto.LocationPetResponseDto;
import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.usecase.domain.LocationPet;
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

    public static LocationPetResponseDto mapToModel(LocationPet localizacaoResponse) {
        return LocationPetResponseDto.builder()
                .country(localizacaoResponse.getCountry())
                .county(localizacaoResponse.getCounty())
                .region(localizacaoResponse.getRegion())
                .neighbourhood(localizacaoResponse.getNeighbourhood())
                .name(localizacaoResponse.getName())
                .build();
    }
}
