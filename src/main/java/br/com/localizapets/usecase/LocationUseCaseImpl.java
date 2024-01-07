package br.com.localizapets.usecase;

import br.com.localizapets.usecase.domain.LocationPet;
import br.com.localizapets.usecase.gateway.LocationApiPet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LocationUseCaseImpl implements LocationUseCase{

    private LocationApiPet locationApiPet;
    @Override
    public LocationPet searchLocation(LocationPet locationModelRequest) {
        return locationApiPet.searchLocation(locationModelRequest);
    }
}
