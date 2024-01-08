package br.com.localizapets.usecase;

import br.com.localizapets.usecase.domain.LocationPet;
import br.com.localizapets.usecase.gateway.LocationApiPet;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static net.logstash.logback.marker.Markers.append;

@Service
@AllArgsConstructor
@Slf4j
public class LocationUseCaseImpl implements LocationUseCase{

    private LocationApiPet locationApiPet;
    @Override
    public LocationPet searchLocation(LocationPet locationModelRequest) {
        log.info(append("PAYLOAD_REQUEST", locationModelRequest),
                "Iniciando a consulta na API externa positionstack");
        return locationApiPet.searchLocation(locationModelRequest);
    }
}
