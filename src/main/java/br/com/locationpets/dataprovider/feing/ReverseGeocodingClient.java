package br.com.locationpets.dataprovider.feing;

import br.com.locationpets.config.security.FeignConfig;
import br.com.locationpets.dataprovider.dto.LocationPetDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(value = "location", url = "${url.api.reverse}", configuration = FeignConfig.class)
public interface ReverseGeocodingClient {

    @GetMapping(value = "/v1/reverse", consumes = APPLICATION_JSON_VALUE)
    LocationPetDto reverseGeocode(@RequestParam("access_key") String accessKey,
                                  @RequestParam("query") String latitude,
                                  @RequestParam("limit") Integer limit);
}
