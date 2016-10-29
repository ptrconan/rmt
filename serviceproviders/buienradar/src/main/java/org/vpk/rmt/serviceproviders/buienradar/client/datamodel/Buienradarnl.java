package org.vpk.rmt.serviceproviders.buienradar.client.datamodel;

//http://cxf.apache.org/docs/jax-rs-client-api.html#JAX-RSClientAPI-CreatingclientsprogrammaticallywithnoSpringdependencies

public class Buienradarnl {
    private Weergegevens weergegevens;

    public Weergegevens getWeergegevens() {
        return weergegevens;
    }

    public void setWeergegevens(Weergegevens weergegevens) {
        this.weergegevens = weergegevens;
    }

    @Override
    public String toString() {
        return "ClassPojo [weergegevens = " + weergegevens + "]";
    }
}
