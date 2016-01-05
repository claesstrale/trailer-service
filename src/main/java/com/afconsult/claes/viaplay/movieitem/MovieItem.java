package com.afconsult.claes.viaplay.movieitem;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Claes on 2015-12-18.
 */
public class MovieItem {
    private String title = null;

    @JsonProperty("_embedded")
    public EmbeddedBlocks embeddedBlocks = null;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EmbeddedBlocks getEmbeddedBlocks() {
        return embeddedBlocks;
    }

    public void setEmbeddedBlocks(EmbeddedBlocks embeddedBlocks) {
        this.embeddedBlocks = embeddedBlocks;
    }
}
