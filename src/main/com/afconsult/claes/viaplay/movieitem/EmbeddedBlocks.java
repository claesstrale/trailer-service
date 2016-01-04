package com.afconsult.claes.viaplay.movieitem;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Claes on 2015-12-18.
 */
public class EmbeddedBlocks {

    @JsonProperty("viaplay:blocks")
    private Blocks[] blocks;

    public Blocks[] getBlocks() {
        return blocks;
    }

    public void setBlocks(Blocks[] blocks) {
        this.blocks = blocks;
    }
}
