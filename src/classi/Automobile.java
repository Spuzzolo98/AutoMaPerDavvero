/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classi;

/**
 *
 * @author sofiataurino
 */
public class Automobile {
    private String Marca, Modello;
    private int Costo,Anno_presentazione;

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModello() {
        return Modello;
    }

    public void setModello(String Modello) {
        this.Modello = Modello;
    }

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }

    public int getAnno_presentazione() {
        return Anno_presentazione;
    }

    public void setAnno_presentazione(int Anno_presentazione) {
        this.Anno_presentazione = Anno_presentazione;
    }

    public Automobile(String Marca, String Modello, int Costo, int Anno_presentazione) {
        this.Marca = Marca;
        this.Modello = Modello;
        this.Costo = Costo;
        this.Anno_presentazione = Anno_presentazione;
    }

    public Automobile() {
    }
    
    
}
