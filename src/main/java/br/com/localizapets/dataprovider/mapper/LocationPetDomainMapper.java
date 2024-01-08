package br.com.localizapets.dataprovider.mapper;

import br.com.localizapets.dataprovider.dto.LocationPetDto;
import br.com.localizapets.usecase.domain.LocationPet;
import org.springframework.stereotype.Component;

@Component
public class LocationPetDomainMapper {

    public static LocationPet toDomain(LocationPetDto locationPetDto) {
        return LocationPet.builder()
                .country(locationPetDto.getData().get(0).getCountry())
                .county(locationPetDto.getData().get(0).getCounty())
                .region(locationPetDto.getData().get(0).getRegion())
                .neighbourhood(locationPetDto.getData().get(0).getNeighbourhood())
                .name(locationPetDto.getData().get(0).getName())
                .build();
    }
}
