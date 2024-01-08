package br.com.localizapets.dataprovider.mapper;

import br.com.localizapets.dataprovider.dto.LocationPetDto;
import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.entrypoint.model.response.LocationModelResponse;
import br.com.localizapets.mocks.LocationMock;
import br.com.localizapets.usecase.domain.LocationPet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LocationPetDomainMapperTest {

    @Test
    public void testMapToDomain() {
        LocationModelResponse request = new LocationModelResponse();
        List locationPetDto =  new ArrayList<LocationPetDto>();
        request.setCountry("Brazil");
        request.setCounty("Sao Paulo");
        request.setRegion("Sao Paulo");
        request.setCounty("Sao Paulo");
        request.setNeighbourhood("Consolação");
        request.setName("Avenida Barata Ribeiro 339");
        LocationPet locationPet = LocationPetDomainMapper.mapToDomain(LocationMock.getLocationDtoResponse());
        assertEquals(request.getCountry(), locationPet.getCountry());
        assertEquals(request.getCounty(), locationPet.getCounty());

    }
}
