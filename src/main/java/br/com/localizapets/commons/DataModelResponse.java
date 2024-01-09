package br.com.localizapets.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class DataModelResponse<T> {

    private T data;
}
