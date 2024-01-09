package br.com.localizapets.dataprovider.implementation;


import br.com.localizapets.dataprovider.feing.ReverseGeocodingClient;
import br.com.localizapets.mocks.LocationMock;
import br.com.localizapets.usecase.domain.LocationPet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class LocationApiPetImplTest {


    LocationApiPetImpl locationApiPet;
    @Mock
    ReverseGeocodingClient reverseGeocodingClient;

    @BeforeEach
    void setup() {
        locationApiPet = new LocationApiPetImpl(reverseGeocodingClient, "teste");
    }

    @Test
    void testConsultLocationSuccess() {
        LocationPet locationPet = new LocationPet();
        locationPet.setIdCollar("12354");
        locationPet.setLatitude("-23.5606209");
        locationPet.setLongitude("-46.6564414");
        when(reverseGeocodingClient.reverseGeocode(eq("teste"), eq(locationPet.getLatitude()
                + "," + locationPet.getLongitude()), any(Integer.class))).thenReturn(LocationMock.getLocationDtoResponse());
        LocationPet response = locationApiPet.searchLocation(locationPet);
        assertAll(
                () -> assertEquals("Brazil", response.getCountry()),
                () -> assertEquals("Sao Paulo", response.getCounty()),
                () -> assertEquals("Sao Paulo", response.getRegion()),
                () -> assertEquals("Consolação", response.getNeighbourhood()),
                () -> assertEquals("Avenida Barata Ribeiro 339", response.getName())
        );
    }
}
