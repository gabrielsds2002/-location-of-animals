package br.com.locationpets.mocks;

import br.com.locationpets.dataprovider.dto.LocationPetDto;
import br.com.locationpets.dataprovider.dto.LocationPetResponseDto;
import br.com.locationpets.entrypoint.model.request.LocationModelRequest;
import br.com.locationpets.usecase.domain.LocationPet;

import java.util.ArrayList;
import java.util.List;

public class LocationMock {

    LocationPet locationPet;

    public static LocationPet getLocationResponse() {
        LocationPet locationPet = new LocationPet();
        locationPet.setCountry("Brazil");
        locationPet.setCounty("Sao Paulo");
        locationPet.setRegion("Sao Paulo");
        locationPet.setNeighbourhood("Consolação");
        locationPet.setName("Avenida Barata Ribeiro 339");
        return locationPet;
    }


    public static LocationPetDto getLocationDtoResponse() {
        LocationPetDto locationPetDto = new LocationPetDto();
        List locationPet = new ArrayList<LocationPetDto>();
        LocationPetResponseDto locationPetResponseDto = new LocationPetResponseDto();
        locationPetResponseDto.setCountry("Brazil");
        locationPetResponseDto.setCounty("Sao Paulo");
        locationPetResponseDto.setRegion("Sao Paulo");
        locationPetResponseDto.setNeighbourhood("Consolação");
        locationPetResponseDto.setName("Avenida Barata Ribeiro 339");
        locationPet.add(locationPetResponseDto);
        locationPetDto.setData(locationPet);
        return locationPetDto;
    }

    public static LocationPet getRequest() {
        LocationPet locationPet = new LocationPet();
        locationPet.setLatitude("-23.5606209");
        locationPet.setLongitude("-46.6564414");
        locationPet.setIdCollar("12315");
        return locationPet;
    }

    public static LocationPet locationPetMock() {
        LocationPet locationPet = new LocationPet();
        locationPet.setCountry("Brazil");
        locationPet.setCounty("Sao Paulo");
        locationPet.setRegion("Sao Paulo");
        locationPet.setNeighbourhood("Consolação");
        locationPet.setName("Avenida Barata Ribeiro 339");
        return locationPet;
    }

    public static LocationModelRequest locationModelRequestMock() {
        LocationModelRequest locationPet = new LocationModelRequest();
        locationPet.setLatitude("10.0");
        locationPet.setLongitude("20.0");
        locationPet.setIdCollar("123");
        return locationPet;
    }


}
