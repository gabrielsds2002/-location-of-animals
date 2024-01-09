package br.com.locationpets.dataprovider.feing;

import br.com.locationpets.exceptions.BadRequestException;
import br.com.locationpets.exceptions.NotFoundException;
import br.com.locationpets.exceptions.UnauthorizedExcepition;
import br.com.locationpets.exceptions.UnprocessableException;
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
                "Error: error in positionstack response API: " + response.reason());
        return switch (response.status()) {
            case 400 -> new BadRequestException("Data sent to api Invalid");
            case 401 -> new UnauthorizedExcepition("Unauthorized user");
            case 404 -> new NotFoundException("Data not found");
            case 422 -> new UnprocessableException("Unable to process data");
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}

