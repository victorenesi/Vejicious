package uk.ac.tees.b1196119.vejicious.Models;

import java.util.ArrayList;

public class WinePairing {
    public ArrayList<String> pairedWines;
    public String pairingText;
    public ArrayList<ProductMatch> productMatches;

    public ArrayList<String> getPairedWines() {
        return pairedWines;
    }

    public void setPairedWines(ArrayList<String> pairedWines) {
        this.pairedWines = pairedWines;
    }

    public String getPairingText() {
        return pairingText;
    }

    public void setPairingText(String pairingText) {
        this.pairingText = pairingText;
    }

    public ArrayList<ProductMatch> getProductMatches() {
        return productMatches;
    }

    public void setProductMatches(ArrayList<ProductMatch> productMatches) {
        this.productMatches = productMatches;
    }
}
