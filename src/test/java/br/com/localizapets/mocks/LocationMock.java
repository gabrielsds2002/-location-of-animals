package br.com.localizapets.mocks;

import br.com.localizapets.dataprovider.dto.LocationPetDto;
import br.com.localizapets.dataprovider.dto.LocationPetResponseDto;
import br.com.localizapets.usecase.domain.LocationPet;

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

//    public static LocationPet getLocationResponse(){
//        LocationPetDto localizacaoData = new LocationPetDto();
//        LocationPetResponse locationPetResponse = new LocationPetResponse();
//        List<LocationPetResponse> response = new ArrayList<>();
//        locationPetResponse.setCountry("Brazil");
//        locationPetResponse.setCounty("Sao Paulo");
//        locationPetResponse.setRegion("Sao Paulo");
//        locationPetResponse.setNeighbourhood("Consolação");
//        locationPetResponse.setName("Avenida Barata Ribeiro 339");
//        response.add(locationPetResponse);
//        localizacaoData.setData(response);
//        return localizacaoData;
//    }


    public static LocationPet getRequest() {
        LocationPet locationPet = new LocationPet();
        locationPet.setLatitude("-23.5606209");
        locationPet.setLongitude("-46.6564414");
        locationPet.setIdCollar("12315");
        return locationPet;
    }


}
