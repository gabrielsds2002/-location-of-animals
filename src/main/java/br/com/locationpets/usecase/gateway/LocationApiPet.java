package br.com.locationpets.usecase.gateway;

import br.com.locationpets.usecase.domain.LocationPet;

public interface LocationApiPet {

    LocationPet searchLocation(LocationPet locationModelRequest);


}
