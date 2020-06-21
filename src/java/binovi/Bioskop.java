/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binovi;

public class Bioskop {
    private int id;
    private String naziv;
    private String adresa;
    private String telefon;
    private String opis;
    private String slika;
    private int menadzer;

    public Bioskop() {
    }

    public Bioskop(int id, String naziv, String adresa, String telefon, String opis, String slika, int menadzer) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.telefon = telefon;
        this.opis = opis;
        this.slika = slika;
        this.menadzer = menadzer;
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getOpis() {
        return opis;
    }

    public String getSlika() {
        return slika;
    }

    public int getMenadzer() {
        return menadzer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public void setMenadzer(int menadzer) {
        this.menadzer = menadzer;
    }
}
