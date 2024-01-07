package br.com.localizapets.usecase.gateway;

import br.com.localizapets.entrypoint.controller.exceptions.response.LocationPetResponse;
import br.com.localizapets.entrypoint.model.request.LocationModelRequest;
import br.com.localizapets.usecase.domain.LocationPet;

public interface LocationApiPet {

    LocationPet searchLocation(LocationPet locationModelRequest);


}
