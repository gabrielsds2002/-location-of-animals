package br.com.localizapets.entrypoint.controller;


import br.com.localizapets.config.WireMockConfiguration;
import br.com.localizapets.mocks.PositionStackApiMock;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ContextConfiguration(classes = {WireMockConfiguration.class})
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ControllerLocalizacaoTest {

    PositionStackApiMock positionStackApiMock = new PositionStackApiMock();
    @Autowired
    private WireMockServer mockServerApiPositionstack;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testConsultLocationSuccess() throws Exception {
        positionStackApiMock.setUpMockApi(mockServerApiPositionstack, "12345", "-23.5606209,-46.6564414", 1);
        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/locationPets/v1/locations?latitude=-23.5606209&longitude=-46.6564414"));
        result.andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.country", Matchers.is("Brazil")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.county", Matchers.is("Sao Paulo")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.region", Matchers.is("Sao Paulo")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.neighbourhood", Matchers.is("Jardim Paulista")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name", Matchers.is("Justiça Federal Fórum Ministro Pedro Lessa")));
    }

    @Test
    public void testConsultLocationBadRequest() throws Exception {
        positionStackApiMock.setUpMockApi400(mockServerApiPositionstack, null, "-23.5606209,-46.6564414", 1);
        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/locationPets/v1/locations?latitude=-23.5606209&longitude=-46.6564414"));
        result.andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Data sent to api Invalid")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("400")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.url_error", Matchers.is("/invalid-field-in-request")));
    }

    @Test
    public void testConsultLocationUnauthorized() throws Exception {
        positionStackApiMock.setUpMockApi401(mockServerApiPositionstack, null, "-23.5606209,-46.6564414", 1);
        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/locationPets/v1/locations?latitude=-23.5606209&longitude=-46.6564414"));
        result.andExpect(status().isUnauthorized())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Unauthorized user")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("401")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.url_error", Matchers.is("/user-unathorizad")));
    }

    @Test
    public void testConsultLocationNotFound() throws Exception {
        positionStackApiMock.setUpMockApi404(mockServerApiPositionstack, null, "-23.5606209,-46.6564414", 1);
        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/locationPets/v1/locations?latitude=-23.5606209&longitude=-46.6564414"));
        result.andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Data not found")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("404")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.url_error", Matchers.is("/register-not-found")));
    }

    @Test
    public void testConsultLocationUnprocessable() throws Exception {
        positionStackApiMock.setUpMockApi422(mockServerApiPositionstack, null, "-23.5606209,-46.6564414", 1);
        var result = this.mockMvc.perform(MockMvcRequestBuilders.get(
                "/locationPets/v1/locations?latitude=-23.5606209&longitude=-46.6564414"));
        result.andExpect(status().isUnprocessableEntity())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Unable to process data")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("422")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.url_error", Matchers.is("/invalid-field-in-search")));
    }
}