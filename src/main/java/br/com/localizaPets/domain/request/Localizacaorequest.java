package br.com.localizaPets.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Localizacaorequest {


    String latitude;
    String longitude;
    String data;
    String hora;
    String IdColeira;
}
