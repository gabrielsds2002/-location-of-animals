package br.com.localizapets.dataprovider.feing;

import br.com.localizapets.config.security.FeignConfig;
import br.com.localizapets.usecase.domain.LocationPetData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(value = "location",
        url ="http://api.positionstack.com",
        configuration = FeignConfig.class)
public interface ReverseGeocodingClient {


    @GetMapping(value = "/v1/reverse",consumes = APPLICATION_JSON_VALUE)
    LocationPetData reverseGeocode(@RequestParam("access_key") String accessKey,
                                   @RequestParam("query") String latitude,
                                   @RequestParam("limit") Integer limit);




}
