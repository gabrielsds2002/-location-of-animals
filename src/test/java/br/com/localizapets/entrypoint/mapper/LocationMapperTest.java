package br.com.localizapets.entrypoint.mapper;


import br.com.localizapets.entrypoint.controller.exceptions.response.LocationPetResponse;
import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.mocks.LocationMock;
import br.com.localizapets.usecase.domain.LocationPet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LocationMapperTest {


    LocationMock locationMock;
    @Test
    public void testMapToDomain() {
        LocationModelRequest request = new LocationModelRequest();
        request.setLatitude("10.0");
        request.setLongitude("20.0");
        request.setIdColeira(123l);
        LocationPet locationPet = LocationMapper.mapToDomain(request);
        assertEquals(request.getLatitude(), locationPet.getLatitude());
        assertEquals(request.getLongitude(), locationPet.getLongitude());

    }
    @Test
    public void testMapToModel() {
        LocationPet locationPet = new LocationPet();
        locationPet.setCountry("Brazil");
        locationPet.setCounty("Sao Paulo");
        locationPet.setRegion("Sao Paulo");
        locationPet.setNeighbourhood("Consolação");
        locationPet.setName("Avenida Barata Ribeiro 339");
        LocationPetResponse response = LocationMapper.mapToModel(locationPet);
        assertEquals(locationMock.getLocationResponse().getCountry(), response.getCountry());
        assertEquals(locationMock.getLocationResponse().getCounty(), response.getCounty());
        assertEquals(locationMock.getLocationResponse().getRegion(), response.getRegion());
        assertEquals(locationMock.getLocationResponse().getNeighbourhood(), response.getNeighbourhood());
        assertEquals(locationMock.getLocationResponse().getName(), response.getName());
    }


}
