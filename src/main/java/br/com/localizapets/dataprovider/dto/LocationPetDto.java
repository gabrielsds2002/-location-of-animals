package br.com.localizapets.dataprovider.dto;

import br.com.localizapets.entrypoint.controller.exceptions.response.LocationPetResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationPetDto {

    private List<LocationPetResponse> data;


    private HttpStatus code;


    private String message;
}
