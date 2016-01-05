package com.afconsult.claes.viaplay.movieitem;

/**
 * Created by Claes on 2016-01-04.
 */
public class Content {
    private String publicPath;
    private String type;
    private Imdb imdb;

    public Imdb getImdb() {
        return imdb;
    }

    public void setImdb(Imdb imdb) {
        this.imdb = imdb;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublicPath() {
        return publicPath;
    }

    public void setPublicPath(String publicPath) {
        this.publicPath = publicPath;
    }
}
