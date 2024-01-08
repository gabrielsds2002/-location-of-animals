package br.com.localizapets.dataprovider.feing;

import br.com.localizapets.exceptions.*;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import static net.logstash.logback.marker.Markers.append;

@Slf4j
public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        log.error(append("PAYLOAD_ERROR_FEING", response),
                "Error: error in positionstack response API: "+response.reason());
        return switch (response.status()) {
            case 400 -> new BadRequestExcepition("Data sent to api Invalid");
            case 401 -> new UnauthorizedExcepition("Unauthorized user");
            case 404 -> new NotFoundExcepition("Data not found");
            case 422 -> new UnprocessableException("Unable to process data");
            case 500 -> new InternalServerError("Internal error");
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}

