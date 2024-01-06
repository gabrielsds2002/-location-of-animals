package br.com.localizapets.dataprovider.implementation;


import br.com.localizapets.dataprovider.mapper.LocationPetDomainMapper;
import br.com.localizapets.dataprovider.repository.LocationPortIn;
import br.com.localizapets.entrypoint.model.request.LocationModelRequest;

import br.com.localizapets.usecase.domain.LocationPetData;
import br.com.localizapets.usecase.domain.response.LocationPetResponse;
import br.com.localizapets.dataprovider.feing.ReverseGeocodingClient;
import org.springframework.stereotype.Service;


@Service

public class LocationPortInImpl implements LocationPortIn {


    private final ReverseGeocodingClient reverseGeocodingClient;
    private final LocationPetDomainMapper locationPetDomainMapper;

    public LocationPortInImpl(ReverseGeocodingClient reverseGeocodingClient, LocationPetDomainMapper locationPetDomainMapper) {
        this.reverseGeocodingClient = reverseGeocodingClient;
        this.locationPetDomainMapper = locationPetDomainMapper;
    }


    @Override
    public LocationPetResponse searchLocation(LocationModelRequest locationModelRequest){
        LocationPetData locationPetData = reverseGeocodingClient.reverseGeocode("bf18401d3d6680ecd5d812e56b0421ab", locationModelRequest.getLatitude() + "," + locationModelRequest.getLongitude(), 1);
        return locationPetDomainMapper.toDomain(locationPetData);
    }
}
