package br.com.localizaPets.mocks;

import br.com.localizaPets.domain.LocalizacaoData;
import br.com.localizaPets.domain.response.LocalizacaoResponse;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class LocationMock {

    public static LocalizacaoData getLocationResponse(){
        LocalizacaoData localizacaoData = new LocalizacaoData();
        LocalizacaoResponse localizacaoResponse = new LocalizacaoResponse();
        List<LocalizacaoResponse> response = new ArrayList<>();
        localizacaoResponse.setCountry("Brazil");
        localizacaoResponse.setCounty("Sao Paulo");
        localizacaoResponse.setRegion("Sao Paulo");
        localizacaoResponse.setNeighbourhood("Consolação");
        localizacaoResponse.setName("Avenida Barata Ribeiro 339");
        response.add(localizacaoResponse);
        localizacaoData.setData(response);
        return localizacaoData;
    }

    public static LocalizacaoData getErrorLat(){
        LocalizacaoData localizacaoData = new LocalizacaoData();
        localizacaoData.setCodigo(HttpStatus.UNPROCESSABLE_ENTITY);
        localizacaoData.setMensagem("Campo Latitude ou Longitude está incorreto");
        return localizacaoData;
    }


}
