package com.afconsult.claes.viaplay.test;

//import org.junit.Assert;
import com.afconsult.claes.viaplay.TrailerLink;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.http.MediaType;
import org.springframework.test.util.AssertionErrors;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Created by Claes on 2016-01-04.
 */
public class TrailerControllerTest extends AbstractControllerTest {

    @Before
    public void setUp(){
        super.setUp();
    }

    @Test
    public void testGetTrailerWithoutParameters() throws Exception {

        String uri = "/trailer";
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("HTTP 400 expected", 400, status);

    }

    @Test
    public void testGetTrailerWithLink () throws Exception {
        String uri = "/trailer?link=https://content.viaplay.se/web-se/film/taken-3-2014";
        String resultJson = "{\"trailerUrl\":\"http://v.traileraddict.com/101260\"}";

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

        String content = result.getResponse().getContentAsString();
        int status = result.getResponse().getStatus();

        Assert.assertEquals("HTTP 200 expected", 200, status);
        Assert.assertEquals("Wrong data returned", resultJson, content);
    }
}
