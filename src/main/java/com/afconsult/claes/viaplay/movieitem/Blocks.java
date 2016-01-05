package com.afconsult.claes.viaplay.movieitem;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Claes on 2015-12-18.
 */
public class Blocks {

    @JsonProperty("_embedded")
    private EmbeddedProduct embeddedProduct;
    private String type = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public EmbeddedProduct getEmbeddedProduct() {
        return embeddedProduct;
    }

    public void setEmbeddedProduct(EmbeddedProduct embeddedProduct) {
        this.embeddedProduct = embeddedProduct;
    }
}
