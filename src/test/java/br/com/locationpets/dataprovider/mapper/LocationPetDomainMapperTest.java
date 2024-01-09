package br.com.locationpets.dataprovider.mapper;


import br.com.locationpets.mocks.LocationMock;
import br.com.locationpets.usecase.domain.LocationPet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

class LocationPetDomainMapperTest {

    @Test
    void testMapToDomainSuccess() {
        LocationPet locationPet = LocationPetDomainMapper.mapToDomain(LocationMock.getLocationDtoResponse());
        assertAll(
                () -> Assertions.assertEquals("Brazil", locationPet.getCountry()),
                () -> Assertions.assertEquals("Sao Paulo", locationPet.getCounty()),
                () -> Assertions.assertEquals("Sao Paulo", locationPet.getRegion()),
                () -> Assertions.assertEquals("Consolação", locationPet.getNeighbourhood()),
                () -> Assertions.assertEquals("Avenida Barata Ribeiro 339", locationPet.getName())
        );
    }
}
