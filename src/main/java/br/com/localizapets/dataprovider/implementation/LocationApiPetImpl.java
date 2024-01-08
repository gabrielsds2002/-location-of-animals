package br.com.localizapets.dataprovider.implementation;


import br.com.localizapets.dataprovider.dto.LocationPetDto;
import br.com.localizapets.dataprovider.feing.ReverseGeocodingClient;
import br.com.localizapets.dataprovider.mapper.LocationPetDomainMapper;
import br.com.localizapets.usecase.domain.LocationPet;
import br.com.localizapets.usecase.gateway.LocationApiPet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static net.logstash.logback.marker.Markers.append;



@Service
@Slf4j
public class LocationApiPetImpl implements LocationApiPet {

    private final ReverseGeocodingClient reverseGeocodingClient;
    private final String accessKey;

    public static final int LIMIT = 10;


    public LocationApiPetImpl(ReverseGeocodingClient reverseGeocodingClient,
                              @Value("${acesskey.api.reverse}") String accessKey) {
        this.reverseGeocodingClient = reverseGeocodingClient;
        this.accessKey = accessKey;
    }

    @Override
    public LocationPet searchLocation(LocationPet locationPet) {
        log.info(append("PAYLOAD_REQUEST", locationPet),
                "Enviando os dados de consulta para API externa positionstack");
        var query = locationPet.getLatitude() + "," + locationPet.getLongitude();
        LocationPetDto locationPetData = reverseGeocodingClient.reverseGeocode(accessKey, query, LIMIT);
        log.info(append("PAYLOAD_REQUEST", locationPet),
                "Finalizando a consulta na API externa positionstack");
        return LocationPetDomainMapper.mapToDomain(locationPetData);
    }
}