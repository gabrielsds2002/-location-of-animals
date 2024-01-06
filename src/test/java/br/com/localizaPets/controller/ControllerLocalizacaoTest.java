package br.com.localizapets.controller;


import br.com.localizapets.dataprovider.repository.LocationPortIn;
import br.com.localizapets.entrypoint.controller.SearchController;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerLocalizacaoTest {
    LocationPortIn localizacaoPortIn;
    SearchController controllerLocalizacao;

//    @BeforeEach
//    public void setup(){
//        localizacaoPortIn = mock(LocalizacaoPortIn.class);
//        controllerLocalizacao = new ControllerLocalizacao(localizacaoPortIn);
//    }

//    @Test
//    public void Location() throws ErroNasApisException {
//        mockLocation();
//        ResponseEntity<LocalizacaoData> response =controllerLocalizacao.consultarLocalizao("12354","135465","","","");
//        assertTrue(response.getBody().getData().get(0).getCountry().equals("Brazil"));
//    }
//
//
//    private void mockLocation() throws ErroNasApisException {
//        when(localizacaoPortIn.consultar(anyString(),anyString(),anyString(),anyString(),anyString())).thenReturn(LocationMock.getLocationResponse());
//    }
}
