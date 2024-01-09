package br.com.localizapets.entrypoint.mapper;


import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.entrypoint.model.response.LocationModelResponse;
import br.com.localizapets.mocks.LocationMock;
import br.com.localizapets.usecase.domain.LocationPet;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertAll;


public class LocationMapperTest {


    @Test
    public void testMapToDomain() {
        LocationPet locationPet = LocationMapper.mapToDomain(locationModelRequestMock());
        assertAll(
                () -> Assertions.assertEquals("10.0", locationPet.getLatitude()),
                () -> Assertions.assertEquals("20.0", locationPet.getLongitude()),
                () -> Assertions.assertEquals("123", locationPet.getIdCollar())
        );
    }

    @Test
    public void testMapToModel() {

        LocationModelResponse response = LocationMapper.mapToModel(locationPetMock());
        assertAll(
                () -> Assertions.assertEquals("Brazil", response.getCountry()),
                () -> Assertions.assertEquals("Sao Paulo", response.getCounty()),
                () -> Assertions.assertEquals("Sao Paulo", response.getRegion()),
                () -> Assertions.assertEquals("Consolação", response.getNeighbourhood()),
                () -> Assertions.assertEquals("Avenida Barata Ribeiro 339", response.getName())
        );
    }

    private LocationPet locationPetMock() {
        LocationPet locationPet = new LocationPet();
        locationPet.setCountry("Brazil");
        locationPet.setCounty("Sao Paulo");
        locationPet.setRegion("Sao Paulo");
        locationPet.setNeighbourhood("Consolação");
        locationPet.setName("Avenida Barata Ribeiro 339");
        return locationPet;
    }

    private LocationModelRequest locationModelRequestMock() {
        LocationModelRequest locationPet = new LocationModelRequest();
        locationPet.setLatitude("10.0");
        locationPet.setLongitude("20.0");
        locationPet.setIdCollar("123");
        return locationPet;
    }
}
