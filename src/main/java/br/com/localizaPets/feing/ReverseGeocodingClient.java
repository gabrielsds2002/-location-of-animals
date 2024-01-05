package br.com.localizaPets.feing;

import br.com.localizaPets.domain.LocalizacaoData;
import feign.Param;
import feign.RequestLine;

public interface ReverseGeocodingClient {

    @RequestLine("GET /v1/reverse?access_key={accessKey}&query={latitude}&limit=1")
    LocalizacaoData reverseGeocode(@Param("accessKey") String accessKey,
                                       @Param("latitude") String latitude);


}
