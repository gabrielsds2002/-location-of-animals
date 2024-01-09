package br.com.locationpets.usecase;

import br.com.locationpets.usecase.domain.LocationPet;
import br.com.locationpets.usecase.gateway.LocationApiPet;
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
                "Starting the query in the positionstack external API");
        return locationApiPet.searchLocation(locationModelRequest);
    }
}
