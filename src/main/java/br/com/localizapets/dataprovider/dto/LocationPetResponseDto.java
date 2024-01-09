package br.com.localizapets.dataprovider.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationPetResponseDto {

    private String country;
    private String county;
    private String region;
    private String neighbourhood;
    private String name;
}
