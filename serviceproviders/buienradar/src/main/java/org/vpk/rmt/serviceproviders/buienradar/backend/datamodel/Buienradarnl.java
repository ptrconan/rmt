package org.vpk.rmt.serviceproviders.buienradar.backend.datamodel;

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
