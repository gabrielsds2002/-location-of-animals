package br.com.localizaPets.service;


import br.com.localizaPets.domain.LocalizacaoData;
import br.com.localizaPets.exceptions.ErroNasApisException;
import br.com.localizaPets.feing.ReverseGeocodingClient;
import feign.Feign;
import feign.FeignException;
import feign.gson.GsonDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service

public class ConsultaLocalizacaoImpl implements ConsultaLocalizacao {


    @Override
    public LocalizacaoData consultar(String latitude, String longitude, String data, String hora, String IdColeira) throws ErroNasApisException {
        try {

            ReverseGeocodingClient client = Feign.builder()
                    .decoder(new GsonDecoder())
                    .target(ReverseGeocodingClient.class, "http://api.positionstack.com");
            LocalizacaoData localizacaoResponse = client.reverseGeocode("c33c9ace68e5c82d947d2b447db012e2", latitude + "," + longitude);
            return localizacaoResponse;
        } catch (FeignException e) {
            int statusCode = e.status();
            if (statusCode == 422) {
                return obterRespostaErro("Campo Latitude ou Longitude está incorreto", HttpStatus.UNPROCESSABLE_ENTITY);
            } else {
                return obterRespostaErro("Recurso não encontrado na API externa", HttpStatus.BAD_REQUEST);
            }
        }
    }

    private LocalizacaoData obterRespostaErro(String msg, HttpStatus status) {
        LocalizacaoData response;
        LocalizacaoData obterResposta = new LocalizacaoData();
        obterResposta.setMensagem(msg);
        obterResposta.setCodigo(HttpStatus.valueOf(status.value()));
        response = obterResposta;
        return response;
    }

}
