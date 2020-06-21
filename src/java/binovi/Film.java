/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binovi;

public class Film {
    private int id;
    private String naziv;
    private String opis;
    private String slika;

    public Film() {
    }

    public Film(int id, String naziv, String opis, String slika) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.slika = slika;
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public String getSlika() {
        return slika;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }
}
