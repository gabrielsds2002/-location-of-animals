package br.com.localizaPets.domain;

import br.com.localizaPets.domain.response.LocalizacaoResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalizacaoData {

    private List<LocalizacaoResponse> data;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private HttpStatus codigo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String mensagem;
}
