package com.afconsult.claes.viaplay.test;

import com.afconsult.claes.viaplay.Application;
import com.afconsult.claes.viaplay.TrailerController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

/**
 * Created by Claes on 2016-01-04.
 */
@WebAppConfiguration
//@IntegrationTest("server.port:0")
public class AbstractControllerTest extends AbstractTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    protected MockMvc mvc;

   @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    protected <T> T mapFromJson(String json, Class<T> className) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json,className);
    }

}
