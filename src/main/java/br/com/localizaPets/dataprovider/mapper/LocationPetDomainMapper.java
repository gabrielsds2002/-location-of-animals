package br.com.localizapets.dataprovider.mapper;

import br.com.localizapets.usecase.domain.LocationPetData;
import br.com.localizapets.usecase.domain.response.LocationPetResponse;
import org.springframework.stereotype.Component;

@Component
public class LocationPetDomainMapper {

    public LocationPetResponse toDomain(LocationPetData localizacaoResponse) {
        return LocationPetResponse.builder()
                .country(localizacaoResponse.getData().get(0).getCountry())
                .county(localizacaoResponse.getData().get(0).getCounty())
                .region(localizacaoResponse.getData().get(0).getRegion())
                .neighbourhood(localizacaoResponse.getData().get(0).getNeighbourhood())
                .name(localizacaoResponse.getData().get(0).getName())
                .build();
    }
}
