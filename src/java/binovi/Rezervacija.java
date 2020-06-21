/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binovi;

public class Rezervacija {
    private int id;
    private int idFilma;
    private float cena;
    private String datum;
    private int idBioskopa;
    private int brojKarata;
    private int idKorisnika;
    private float poeni;
    private int idProjekcije;
    private int idSale;

    public Rezervacija() {
    }

    public Rezervacija(int id, int idFilma, float cena, String datum, int idBioskopa, int brojKarata, int idKorisnika, float poeni, int idProjekcije, int idSale) {
        this.id = id;
        this.idFilma = idFilma;
        this.cena = cena;
        this.datum = datum;
        this.idBioskopa = idBioskopa;
        this.brojKarata = brojKarata;
        this.idKorisnika = idKorisnika;
        this.poeni = poeni;
        this.idProjekcije = idProjekcije;
        this.idSale = idSale;
    }

    public int getIdSale() {
        return idSale;
    }

    public int getIdProjekcije() {
        return idProjekcije;
    }

    public float getPoeni() {
        return poeni;
    }

    public int getBrojKarata() {
        return brojKarata;
    }

    public float getCena() {
        return cena;
    }

    public String getDatum() {
        return datum;
    }

    public int getId() {
        return id;
    }

    public int getIdBioskopa() {
        return idBioskopa;
    }

    public int getIdFilma() {
        return idFilma;
    }

    public int getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public void setIdProjekcije(int idProjekcije) {
        this.idProjekcije = idProjekcije;
    }
    
    public void setPoeni(float poeni) {
        this.poeni = poeni;
    }

    public void setBrojKarata(int brojKarata) {
        this.brojKarata = brojKarata;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdBioskopa(int idBioskopa) {
        this.idBioskopa = idBioskopa;
    }

    public void setIdFilma(int idFilma) {
        this.idFilma = idFilma;
    }

    public void setIdKorisnika(int idKorisnika) {
        this.idKorisnika = idKorisnika;
    }
}
