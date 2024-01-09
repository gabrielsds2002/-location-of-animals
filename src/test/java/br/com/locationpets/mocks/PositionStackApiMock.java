package br.com.locationpets.mocks;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PositionStackApiMock {

    public void setUpMockApi(WireMockServer mockServer, String accessKey, String query, Integer limit) throws IOException {
        mockServer.stubFor(WireMock.get(WireMock.urlPathMatching("/v1/reverse".concat(".*")))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(IOUtils.toString(this.getClass().getResourceAsStream("/api/mockApi.json"), StandardCharsets.UTF_8))));
    }

    public void setUpMockApi400(WireMockServer mockServer, String accessKey, String query, Integer limit) throws IOException {
        mockServer.stubFor(WireMock.get(WireMock.urlPathMatching("/v1/reverse".concat(".*")))
                .willReturn(WireMock.aResponse()
                        .withStatus(400)
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(IOUtils.toString(this.getClass().getResourceAsStream("/api/mockApiBadRequest.json"), StandardCharsets.UTF_8))));
    }

    public void setUpMockApi401(WireMockServer mockServer, String accessKey, String query, Integer limit) throws IOException {
        mockServer.stubFor(WireMock.get(WireMock.urlPathMatching("/v1/reverse".concat(".*")))
                .willReturn(WireMock.aResponse()
                        .withStatus(401)
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(IOUtils.toString(this.getClass().getResourceAsStream("/api/mockApiUnauthorized.json"), StandardCharsets.UTF_8))));
    }

    public void setUpMockApi404(WireMockServer mockServer, String accessKey, String query, Integer limit) throws IOException {
        mockServer.stubFor(WireMock.get(WireMock.urlPathMatching("/v1/reverse".concat(".*")))
                .willReturn(WireMock.aResponse()
                        .withStatus(404)
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(IOUtils.toString(this.getClass().getResourceAsStream("/api/mockApiNotFound.json"), StandardCharsets.UTF_8))));
    }

    public void setUpMockApi422(WireMockServer mockServer, String accessKey, String query, Integer limit) throws IOException {
        mockServer.stubFor(WireMock.get(WireMock.urlPathMatching("/v1/reverse".concat(".*")))
                .willReturn(WireMock.aResponse()
                        .withStatus(422)
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(IOUtils.toString(this.getClass().getResourceAsStream("/api/mockApiUnprocessable.json"), StandardCharsets.UTF_8))));
    }

}
