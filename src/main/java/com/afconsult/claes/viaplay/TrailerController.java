package com.afconsult.claes.viaplay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Claes on 2015-12-18.
 */
@RestController
public class TrailerController {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private final String marker = "TrailerController: ";

    @Autowired
    private DataFetcherRepository df;

    /**
     * /trailer request handler. Requires a link as parameter
     * @param link Required, Viaplay movie item link
     * @return JSON object containing a trailer link to the requested movie
     */
    @RequestMapping(path = "/trailer", method = RequestMethod.GET)
    public TrailerLink trailer(@RequestParam(value = "link")String link){
        log.info(marker + "Get ready for fetching data");
        String title = df.getResourceLink(link);
        log.info(marker + "Data fetched");
        return new TrailerLink(title);
    }
}
