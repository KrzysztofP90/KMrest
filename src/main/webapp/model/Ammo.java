package model;

import javax.persistence.*;

@Entity

public class Ammo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Calibre calibre;
    private double price;

    public Ammo() {
    }

    public int getId() {
        return id;
    }

    public Calibre getCalibre() {
        return calibre;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCalibre(Calibre calibre) {
        this.calibre = calibre;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
