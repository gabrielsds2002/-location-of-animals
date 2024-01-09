package br.com.localizapets.dataprovider.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationPetDto {

    private List<LocationPetResponseDto> data;

}
