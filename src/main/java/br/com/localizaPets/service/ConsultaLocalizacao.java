package br.com.localizaPets.service;

import br.com.localizaPets.domain.LocalizacaoData;
import br.com.localizaPets.exceptions.ErroNasApisException;

public interface ConsultaLocalizacao {


    LocalizacaoData consultar(String latitude, String longitude,
                              String data, String hora, String IdColeira) throws ErroNasApisException;
}
