package br.com.localizaPets.service;

import br.com.localizaPets.domain.LocalizacaoData;
import br.com.localizaPets.exceptions.ErroNasApisException;
import br.com.localizaPets.mocks.LocationMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ConsultaLocalizacaoImplTest {


    ConsultaLocalizacao consultaLocalizacao;
    ConsultaLocalizacaoImpl consultaLocalizacaoImpl;

    @BeforeEach
    public void setup(){
        consultaLocalizacao = mock(ConsultaLocalizacao.class);
        consultaLocalizacaoImpl = new ConsultaLocalizacaoImpl();
    }

    @Test
    public void Location() throws ErroNasApisException {
        mockLocation();
        LocalizacaoData response =consultaLocalizacaoImpl.consultar("-23.556831106","-46.653830718","","","");
        assertTrue(response.getData().get(0).getCountry().equals("Brazil"));
    }

    @Test
    public void LocationErroLat() throws ErroNasApisException {
        mockLocationErrorLat();
        LocalizacaoData response =consultaLocalizacaoImpl.consultar("-a23.556831106","-46.653830718","","","");
        assertTrue(response.getCodigo().equals(HttpStatus.UNPROCESSABLE_ENTITY));
    }
    
    private void mockLocation() throws ErroNasApisException {
        when(consultaLocalizacao.consultar(anyString(),anyString(),anyString(),anyString(),anyString())).thenReturn(LocationMock.getLocationResponse());
    }

    private void mockLocationErrorLat() throws ErroNasApisException {
        when(consultaLocalizacao.consultar(anyString(),anyString(),anyString(),anyString(),anyString())).thenReturn(LocationMock.getErrorLat());
    }
}

