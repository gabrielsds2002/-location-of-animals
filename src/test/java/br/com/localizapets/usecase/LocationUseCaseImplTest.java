package br.com.localizapets.usecase;

import br.com.localizapets.mocks.LocationMock;
import br.com.localizapets.usecase.domain.LocationPet;
import br.com.localizapets.usecase.gateway.LocationApiPet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class LocationUseCaseImplTest {

    @Mock
    LocationApiPet locationApiPet;

    @InjectMocks
    LocationUseCaseImpl locationUseCase;

    @Test
    public void testConsultLocationSuccess() {
        when(locationApiPet.searchLocation(any(LocationPet.class))).thenReturn(LocationMock.getLocationResponse());
        LocationPet response = locationUseCase.searchLocation(LocationMock.getRequest());
        assertAll(
                () -> Assertions.assertEquals("Brazil", response.getCountry()),
                () -> Assertions.assertEquals("Sao Paulo", response.getCounty()),
                () -> Assertions.assertEquals("Sao Paulo", response.getRegion()),
                () -> Assertions.assertEquals("Consolação", response.getNeighbourhood()),
                () -> Assertions.assertEquals("Avenida Barata Ribeiro 339", response.getName())
        );
    }
}
