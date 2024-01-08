package br.com.localizapets.dataprovider.implementation;

import br.com.localizapets.dataprovider.dto.LocationPetDto;
import br.com.localizapets.dataprovider.feing.ReverseGeocodingClient;
import br.com.localizapets.dataprovider.mapper.LocationPetDomainMapper;
import br.com.localizapets.dataprovider.mapper.LocationPetDomainMapperTest;
import br.com.localizapets.mocks.LocationMock;
import br.com.localizapets.usecase.domain.LocationPet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocationApiPetImplTest {


    LocationPetDto locationPetDto;
    ReverseGeocodingClient reverseGeocodingClient;
    LocationPetDomainMapper locationPetDomainMapper;

    LocationApiPetImpl locationApiPet;

    @BeforeEach
    public void setup() {
        locationPetDomainMapper = mock(LocationPetDomainMapper.class);
        reverseGeocodingClient = mock(ReverseGeocodingClient.class);
        locationApiPet = new LocationApiPetImpl(reverseGeocodingClient,locationPetDomainMapper);
    }

    @Test
    public void testConsultLocationSuccess() {
        LocationPet locationPet = new LocationPet();
        locationPet.setIdColeira(12354l);
        locationPet.setLatitude("-23.5606209");
        locationPet.setLongitude("-46.6564414");
        when(reverseGeocodingClient.reverseGeocode(anyString(), anyString(), anyInt())).thenReturn(LocationMock.getLocationDtoResponse());
        LocationPet response = locationApiPet.searchLocation(locationPet);
        assertEquals("Brazil", response.getCountry());
    }
}
