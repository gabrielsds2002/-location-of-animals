package br.com.localizapets.entrypoint.controller;


import br.com.localizapets.commons.DataModelResponse;
import br.com.localizapets.entrypoint.controller.SearchController;
import br.com.localizapets.entrypoint.controller.exceptions.response.LocationPetResponse;
import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.exceptions.InternalServerError;
import br.com.localizapets.mocks.LocationMock;
import br.com.localizapets.usecase.LocationUseCase;
import br.com.localizapets.usecase.domain.LocationPet;
import br.com.localizapets.usecase.gateway.LocationApiPet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerLocalizacaoTest {

    LocationUseCase locationUseCase;
    SearchController searchController;

    @BeforeEach
    public void setup() {
        locationUseCase = mock(LocationUseCase.class);
        searchController = new SearchController(locationUseCase);
    }

    @Test
    public void testConsultLocationSuccess() {
        LocationModelRequest locationModelRequest = new LocationModelRequest();
        locationModelRequest.setIdColeira(12354l);
        locationModelRequest.setLatitude("-23.5606209");
        locationModelRequest.setLongitude("-46.6564414");
        when(locationUseCase.searchLocation(any(LocationPet.class))).thenReturn(LocationMock.getLocationResponse());
        ResponseEntity<DataModelResponse<LocationPetResponse>> response = searchController.consultLocation(locationModelRequest);
        assertEquals("Brazil", response.getBody().getData().getCountry());
    }
}