package br.com.localizaPets.domain.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalizacaoResponse {

    @JsonAlias({"country", "country_name"})
    private String country;

    @JsonAlias({"county", "county_name"})
    private String county;

    @JsonAlias({"region", "region_name"})
    private String region;

    @JsonAlias({"neighbourhood", "neighbourhood_name"})
    private String neighbourhood;

    private String name;
}
