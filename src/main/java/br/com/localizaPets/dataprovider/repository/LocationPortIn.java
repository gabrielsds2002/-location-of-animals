package br.com.localizapets.dataprovider.repository;

import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.usecase.domain.response.LocationPetResponse;

public interface LocationPortIn {


    LocationPetResponse searchLocation(LocationModelRequest locationModelRequest);
}
