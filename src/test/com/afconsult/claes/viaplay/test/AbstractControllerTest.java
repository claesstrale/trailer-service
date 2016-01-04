package com.afconsult.claes.viaplay.test;

import com.afconsult.claes.viaplay.Application;
import com.afconsult.claes.viaplay.TrailerController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Claes on 2016-01-04.
 */
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class AbstractControllerTest extends AbstractTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;

//    @Autowired
//    private TrailerController tc;

    protected MockMvc mvc;

   @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetLink(){
    }
}
