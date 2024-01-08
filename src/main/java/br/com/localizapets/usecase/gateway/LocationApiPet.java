package br.com.localizapets.usecase.gateway;

import br.com.localizapets.usecase.domain.LocationPet;

public interface LocationApiPet {

    LocationPet searchLocation(LocationPet locationModelRequest);


}
