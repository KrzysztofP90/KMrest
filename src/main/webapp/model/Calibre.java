package model;

import javax.persistence.*;

@Entity

public class Calibre implements Model{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private long id;

    private double size;


    public Calibre() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
