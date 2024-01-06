package br.com.localizapets.commons;

import org.springframework.stereotype.Component;

@Component
public class DataModelMapper<T> {

    public DataModelResponse setDataModel(T generic) {
        return DataModelResponse.builder()
                .data(generic)
                .build();
    }
}
