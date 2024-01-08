package br.com.localizapets.entrypoint.controller;


import br.com.localizapets.commons.DataModelResponse;
import br.com.localizapets.dataprovider.dto.LocationPetResponseDto;
import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.mocks.LocationMock;
import br.com.localizapets.usecase.LocationUseCase;
import br.com.localizapets.usecase.domain.LocationPet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerLocalizacaoTest {

    LocationUseCase locationUseCase;
    LocationController locationController;

    @BeforeEach
    public void setup() {
        locationUseCase = mock(LocationUseCase.class);
        locationController = new LocationController(locationUseCase);
    }

    @Test
    public void testConsultLocationSuccess() {
        LocationModelRequest locationModelRequest = new LocationModelRequest();
        locationModelRequest.setIdCollar("12354");
        locationModelRequest.setLatitude("-23.5606209");
        locationModelRequest.setLongitude("-46.6564414");
        when(locationUseCase.searchLocation(any(LocationPet.class))).thenReturn(LocationMock.getLocationResponse());
        ResponseEntity<DataModelResponse<LocationPetResponseDto>> response = locationController.consultLocation(locationModelRequest);
        assertEquals("Brazil", response.getBody().getData().getCountry());
    }
}