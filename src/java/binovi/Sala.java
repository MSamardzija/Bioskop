/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binovi;

public class Sala {
    private int id;
    private int idBioskopa;
    private String opis;
    private int brojMesta;
    private int BrojSlobodnihMesta;

    public Sala() {
    }

    public Sala(int id, int idBioskopa, String opis, int brojMesta, int BrojSlobodnihMesta) {
        this.id = id;
        this.idBioskopa = idBioskopa;
        this.opis = opis;
        this.brojMesta = brojMesta;
        this.BrojSlobodnihMesta = BrojSlobodnihMesta;
    }

    public int getBrojMesta() {
        return brojMesta;
    }

    public int getBrojSlobodnihMesta() {
        return BrojSlobodnihMesta;
    }

    public int getId() {
        return id;
    }

    public int getIdBioskopa() {
        return idBioskopa;
    }

    public String getOpis() {
        return opis;
    }

    public void setBrojMesta(int brojMesta) {
        this.brojMesta = brojMesta;
    }

    public void setBrojSlobodnihMesta(int BrojSlobodnihMesta) {
        this.BrojSlobodnihMesta = BrojSlobodnihMesta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdBioskopa(int idBioskopa) {
        this.idBioskopa = idBioskopa;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
