/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekat2;

/**
 *
 * @author cwiki
 */
public class Student {
    
    
    String ime, prezime, predmet;
    int indeks, ocena;
    double bodovi;


    public Student(String ime, String prezime, String predmet, int indeks, int ocena, double bodovi) {
        this.ime = ime;
        this.prezime = prezime;
        this.predmet = predmet;
        this.indeks = indeks;
        this.ocena = ocena;
        this.bodovi = bodovi;
    }

    public Student() {
    }
    
    public Student(String ime, String prezime, int indeks,String predmet,double bodovi, int ocena) {
        this.ime = ime;
        this.prezime = prezime;
        this.predmet = predmet;
        this.indeks = indeks;
        this.ocena = ocena;
        this.bodovi = bodovi;
    }

  
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public double getBodovi() {
        return bodovi;
    }

    public void setBodovi(double bodovi) {
        this.bodovi = bodovi;
    }

  
    
    
            
}
