package br.com.localizapets.usecase.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationPetResponse {


    private String country;


    private String county;

    private String region;

    private String neighbourhood;

    private String name;
}
