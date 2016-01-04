package com.afconsult.claes.viaplay.movieitem;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Claes on 2016-01-04.
 */
public class EmbeddedProduct {
    @JsonProperty("viaplay:product")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
