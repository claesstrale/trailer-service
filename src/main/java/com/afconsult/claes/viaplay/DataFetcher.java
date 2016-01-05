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
 *
 * The DataFetcher first fetches movie info from viaplay and extracts the IMDB ID.
 * After that it fetches trailer data about that movie using the IMDB ID and extracts the trailer URL and returns it.
 * The getResourceLink method is cached (currently in RAM) so external data suppliers will not be bothered too much. =)
 */
@Component
public class DataFetcher implements DataFetcherRepository {

    private final String trailerUrlPattern = "\\/([\\/\\w\\.]*)";
    private final String trailerAddictUrl = "http://api.traileraddict.com/?imdb=";

    /**
     * Fetches data from data suppliers and returns a trailer URL
     * @param url  Viaplay movie item URL.
     * @return Returns trailer URL
     */
    @Cacheable("resourceLink")
    public String getResourceLink(String url){
        // If not, fetch data from resource
        RestTemplate restTemplate = new RestTemplate();
        MovieItem item = restTemplate.getForObject(url, MovieItem.class);

        // Get the IMDB id
        String imdbId = item.getEmbeddedBlocks().getBlocks()[0].getEmbeddedProduct().getProduct().getContent().getImdb().getId();

        // Remove all but digits
        imdbId = imdbId.replaceAll("\\D+","");

        // get trailer data
        TrailerItem tItem = restTemplate.getForObject(trailerAddictUrl + imdbId, TrailerItem.class);

        // extract the trailer url
        Pattern urlPattern = Pattern.compile(trailerUrlPattern);
        Matcher m = urlPattern.matcher(tItem.getTrailer()[0].getEmbed());
        String trailerUrl = null;
        if(m.find()){
            trailerUrl = "http:" + m.group();
        }

        return trailerUrl;
    }
}
