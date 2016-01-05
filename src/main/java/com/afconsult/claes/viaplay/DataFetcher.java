package com.afconsult.claes.viaplay;

import com.afconsult.claes.viaplay.movieitem.MovieItem;
import com.afconsult.claes.viaplay.traileritem.TrailerItem;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Claes on 2015-12-18.
 */
@Component
public class DataFetcher implements DataFetcherRepository {

    private final String trailerUrlPattern = "\\/([\\/\\w\\.]*)";
    private final String trailerAddictUrl = "http://api.traileraddict.com/?imdb=";

    @Cacheable("resourceLink")
    public String getResourceLink(String url){
        // Verify in db if link is already fetched.

        // If not, fetch data from resource
        RestTemplate restTemplate = new RestTemplate();
        MovieItem item = restTemplate.getForObject(url, MovieItem.class);

        // Get the IMDB id
        String imdbId = item.getEmbeddedBlocks().getBlocks()[0].getEmbeddedProduct().getProduct().getContent().getImdb().getId();

        // Remove all but digits
        imdbId = imdbId.replaceAll("\\D+","");

        // get trailer data
        RestTemplate restTemplate2 = new RestTemplate();
        TrailerItem tItem = restTemplate2.getForObject(trailerAddictUrl + imdbId, TrailerItem.class);

        // extract the trailer url
        Pattern urlPattern = Pattern.compile(trailerUrlPattern);
        Matcher m = urlPattern.matcher(tItem.getTrailer()[0].getEmbed());
        String trailerUrl = null;
        if(m.find()){
            trailerUrl = "http:" + m.group();
        }


        // then get link using imdb id from trailer addict


        return trailerUrl;
    }
}
