package br.com.localizapets.dataprovider.mapper;

import br.com.localizapets.dataprovider.dto.LocationPetDto;
import br.com.localizapets.usecase.domain.LocationPet;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationPetDomainMapper {

    public static LocationPet mapToDomain(LocationPetDto locationPetDto) {
        return LocationPet.builder()
                .country(locationPetDto.getData().get(0).getCountry())
                .county(locationPetDto.getData().get(0).getCounty())
                .region(locationPetDto.getData().get(0).getRegion())
                .neighbourhood(locationPetDto.getData().get(0).getNeighbourhood())
                .name(locationPetDto.getData().get(0).getName())
                .build();
    }
}
