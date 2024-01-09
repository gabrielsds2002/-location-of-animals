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
        LocationPet locationPet = LocationMapper.mapToDomain(LocationMock.locationModelRequestMock());
        assertAll(
                () -> Assertions.assertEquals("10.0", locationPet.getLatitude()),
                () -> Assertions.assertEquals("20.0", locationPet.getLongitude()),
                () -> Assertions.assertEquals("123", locationPet.getIdCollar())
        );
    }

    @Test
    public void testMapToModel() {

        LocationModelResponse response = LocationMapper.mapToModel(LocationMock.locationPetMock());
        assertAll(
                () -> Assertions.assertEquals("Brazil", response.getCountry()),
                () -> Assertions.assertEquals("Sao Paulo", response.getCounty()),
                () -> Assertions.assertEquals("Sao Paulo", response.getRegion()),
                () -> Assertions.assertEquals("Consolação", response.getNeighbourhood()),
                () -> Assertions.assertEquals("Avenida Barata Ribeiro 339", response.getName())
        );
    }


}
