package br.com.localizapets.usecase.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationPet {

    private String latitude;
    private String longitude;
    private String idCollar;
    private String country;
    private String county;
    private String region;
    private String neighbourhood;
    private String name;
}
