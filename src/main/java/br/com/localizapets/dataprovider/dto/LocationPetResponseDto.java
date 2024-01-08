package br.com.localizapets.dataprovider.dto;

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
public class LocationPetResponseDto {

    private String country;
    private String county;
    private String region;
    private String neighbourhood;
    private String name;
}
