package br.com.locationpets.usecase;

import br.com.locationpets.usecase.domain.LocationPet;

public interface LocationUseCase {

    LocationPet searchLocation(LocationPet locationModelRequest);
}
