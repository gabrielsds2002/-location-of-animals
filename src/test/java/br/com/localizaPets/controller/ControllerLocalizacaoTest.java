package br.com.localizaPets.controller;


import br.com.localizaPets.domain.LocalizacaoData;
import br.com.localizaPets.exceptions.ErroNasApisException;
import br.com.localizaPets.mocks.LocationMock;
import br.com.localizaPets.service.ConsultaLocalizacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ControllerLocalizacaoTest {
    ConsultaLocalizacao consultaLocalizacao;
    ControllerLocalizacao controllerLocalizacao;

    @BeforeEach
    public void setup(){
        consultaLocalizacao = mock(ConsultaLocalizacao.class);
        controllerLocalizacao = new ControllerLocalizacao(consultaLocalizacao);
    }

    @Test
    public void Location() throws ErroNasApisException {
        mockLocation();
        ResponseEntity<LocalizacaoData> response =controllerLocalizacao.consultarLocalizao("12354","135465","","","");
        assertTrue(response.getBody().getData().get(0).getCountry().equals("Brazil"));
    }


    private void mockLocation() throws ErroNasApisException {
        when(consultaLocalizacao.consultar(anyString(),anyString(),anyString(),anyString(),anyString())).thenReturn(LocationMock.getLocationResponse());
    }
}
