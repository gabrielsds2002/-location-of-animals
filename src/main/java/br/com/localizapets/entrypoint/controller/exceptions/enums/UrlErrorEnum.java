package br.com.localizapets.entrypoint.controller.exceptions.enums;

import lombok.Getter;
import java.util.Objects;

@Getter
public enum UrlErrorEnum {

    NOT_FOUND("/register-not-found", 404),
    BAD_REQUEST("/invalid-field-in-request", 400),
    UNPROCESSABLE_ENTITY("/invalid-field-in-search", 422),
    INTERNAL_SERVER("/generic-error", 500);

    private String url;
    private Integer httpStatus;

    UrlErrorEnum(String url, Integer httpStatus) {
        this.url = url;
        this.httpStatus = httpStatus;
    }

    public static String searchUrl(Integer httpStatusValue) {
        if (Objects.nonNull(httpStatusValue)) {
            for (UrlErrorEnum urlErrorEnum : values()) {
                if (urlErrorEnum.getHttpStatus().equals(httpStatusValue)) {
                    return urlErrorEnum.getUrl();
                }
            }
        }
        return UrlErrorEnum.INTERNAL_SERVER.getUrl();
    }
}
