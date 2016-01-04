package com.afconsult.claes.viaplay.traileritem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Claes on 2016-01-04.
 */
@XmlRootElement(name="trailers")
@XmlAccessorType(XmlAccessType.FIELD)
public class TrailerItem {

    @XmlElement(name="trailer")
    Trailer[] trailer;

    public Trailer[] getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer[] trailer) {
        this.trailer = trailer;
    }
}
