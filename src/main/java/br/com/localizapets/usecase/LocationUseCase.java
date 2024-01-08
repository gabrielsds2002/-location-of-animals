package br.com.localizapets.usecase;

import br.com.localizapets.usecase.domain.LocationPet;

public interface LocationUseCase {

    LocationPet searchLocation(LocationPet locationModelRequest);
}
