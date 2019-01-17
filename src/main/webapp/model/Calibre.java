package model;

import javax.persistence.*;

@Entity

public class Calibre {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id;

    private double size;





    public Calibre() {
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
