package br.com.localizapets.mocks;

import br.com.localizapets.usecase.domain.LocationPetData;
import br.com.localizapets.usecase.domain.response.LocationPetResponse;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class LocationMock {

    public static LocationPetData getLocationResponse(){
        LocationPetData localizacaoData = new LocationPetData();
        LocationPetResponse locationPetResponse = new LocationPetResponse();
        List<LocationPetResponse> response = new ArrayList<>();
        locationPetResponse.setCountry("Brazil");
        locationPetResponse.setCounty("Sao Paulo");
        locationPetResponse.setRegion("Sao Paulo");
        locationPetResponse.setNeighbourhood("Consolação");
        locationPetResponse.setName("Avenida Barata Ribeiro 339");
        response.add(locationPetResponse);
        localizacaoData.setData(response);
        return localizacaoData;
    }

    public static LocationPetData getErrorLat(){
        LocationPetData localizacaoData = new LocationPetData();
        localizacaoData.setCode(HttpStatus.UNPROCESSABLE_ENTITY);
        localizacaoData.setMessage("Campo Latitude ou Longitude está incorreto");
        return localizacaoData;
    }


}
