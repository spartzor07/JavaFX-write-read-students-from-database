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
public class StudentLicni {
    
    
    String ime, prezime, ulica, grad, jmbg;
    int indeks;

    public StudentLicni(String ime, String prezime, int indeks, String ulica, String grad,  String jmbg) {
        this.ime = ime;
        this.prezime = prezime;
        this.ulica = ulica;
        this.grad = grad;
        this.indeks = indeks;
        this.jmbg = jmbg;
    }

    public StudentLicni() {
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

    public void setPerzime(String prezime) {
        this.prezime = prezime;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getIndeks() {
        return indeks;
    }

    public void setIndeks(int indeks) {
        this.indeks = indeks;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
    
    
    
}
