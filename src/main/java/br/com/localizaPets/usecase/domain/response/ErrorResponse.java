package br.com.localizapets.usecase.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    @JsonProperty("code")
    private HttpStatus code;

    @JsonProperty("message")
    private String message;

    @JsonProperty("description")
    private String description;
}
