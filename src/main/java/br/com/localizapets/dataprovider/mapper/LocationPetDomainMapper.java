package br.com.localizapets.dataprovider.mapper;

import br.com.localizapets.dataprovider.dto.LocationPetDto;
import br.com.localizapets.usecase.domain.LocationPet;
import org.springframework.stereotype.Component;

@Component
public class LocationPetDomainMapper {

    public static LocationPet toDomain(LocationPetDto localizacaoResponse) {
        return LocationPet.builder()
                .country(localizacaoResponse.getData().get(0).getCountry())
                .county(localizacaoResponse.getData().get(0).getCounty())
                .region(localizacaoResponse.getData().get(0).getRegion())
                .neighbourhood(localizacaoResponse.getData().get(0).getNeighbourhood())
                .name(localizacaoResponse.getData().get(0).getName())
                .build();
    }
}
