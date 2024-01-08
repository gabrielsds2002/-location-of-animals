package br.com.localizapets.usecase;

import br.com.localizapets.mocks.LocationMock;
import br.com.localizapets.usecase.domain.LocationPet;
import br.com.localizapets.usecase.gateway.LocationApiPet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LocationUseCaseImplTest {

    LocationApiPet locationApiPet;

    LocationUseCaseImpl locationUseCase;
    @BeforeEach
    public void setup() {
        locationApiPet = mock(LocationApiPet.class);
        locationUseCase = new LocationUseCaseImpl(locationApiPet);
    }

    @Test
    public void testConsultLocationSuccess() {
        LocationPet locationPet = new LocationPet();
        locationPet.setCountry("Brazil");
        LocationPet response = locationUseCase.searchLocation(locationPet);
        when(locationApiPet.searchLocation(any(LocationPet.class))).thenReturn(LocationMock.getLocationResponse());
        assertEquals("Brazil", response.getCountry());
    }
}
