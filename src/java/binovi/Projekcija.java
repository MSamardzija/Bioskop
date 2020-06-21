/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binovi;

public class Projekcija {
    private int id;
    private float cenaKarte;
    private String datum;
    private int idBioskopa;
    private int idFilma;
    private int idSale;

    public Projekcija() {
    }

    public Projekcija(int id, float cenaKarte, String datum, int idBioskopa, int idFilma, int idSale) {
        this.id = id;
        this.cenaKarte = cenaKarte;
        this.datum = datum;
        this.idBioskopa = idBioskopa;
        this.idFilma = idFilma;
        this.idSale = idSale;
    }

    public float getCenaKarte() {
        return cenaKarte;
    }

    public int getIdBioskopa() {
        return idBioskopa;
    }

    public String getDatum() {
        return datum;
    }

    public int getId() {
        return id;
    }

    public int getIdFilma() {
        return idFilma;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCenaKarte(float cenaKarte) {
        this.cenaKarte = cenaKarte;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setIdBioskopa(int idBioskopa) {
        this.idBioskopa = idBioskopa;
    }

    public void setIdFilma(int idFilma) {
        this.idFilma = idFilma;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }
}
