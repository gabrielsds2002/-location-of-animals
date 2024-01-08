package br.com.localizapets.dataprovider.implementation;


import br.com.localizapets.dataprovider.dto.LocationPetDto;
import br.com.localizapets.dataprovider.mapper.LocationPetDomainMapper;
import br.com.localizapets.usecase.domain.LocationPet;
import br.com.localizapets.dataprovider.feing.ReverseGeocodingClient;
import br.com.localizapets.usecase.gateway.LocationApiPet;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class LocationApiPetImpl implements LocationApiPet {

    private final ReverseGeocodingClient reverseGeocodingClient;
    private final LocationPetDomainMapper locationPetDomainMapper;

    @Override
    public LocationPet searchLocation(LocationPet locationPet) {
        log.info("BEGIN - LocationApiPetImpl.searchLocation");
        LocationPetDto locationPetData = reverseGeocodingClient.reverseGeocode("bf18401d3d6680ecd5d812e56b0421ab", locationPet.getLatitude() + "," + locationPet.getLongitude(), 1);
        log.info("END - LocationApiPetImpl.searchLocation");
        return locationPetDomainMapper.toDomain(locationPetData);
    }
}
