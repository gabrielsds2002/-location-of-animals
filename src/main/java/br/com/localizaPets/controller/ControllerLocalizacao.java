package br.com.localizaPets.controller;

import br.com.localizaPets.domain.LocalizacaoData;
import br.com.localizaPets.exceptions.ErroNasApisException;
import br.com.localizaPets.service.ConsultaLocalizacao;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ControllerLocalizacao {

    private ConsultaLocalizacao consultaLocalizacao;


    @GetMapping("/cadastro")
    public ResponseEntity<LocalizacaoData> consultarLocalizao(@RequestParam(name = "latitude",required = true) String latitude,
                                                              @RequestParam(name = "longitude",required = true) String longitude,
                                                              @RequestParam(name = "data",required = false) String data,
                                                              @RequestParam(name = "hora",required = false) String hora,
                                                              @RequestParam(name = "IdColeira",required = false) String IdColeira) throws ErroNasApisException {
        LocalizacaoData response =consultaLocalizacao.consultar(latitude,longitude,data,hora,IdColeira);
        if(response.getCodigo()!=null){
            return ResponseEntity.status(response.getCodigo()).body(response);
        }
        else {
            return ResponseEntity.ok(response);
        }
    }



}
