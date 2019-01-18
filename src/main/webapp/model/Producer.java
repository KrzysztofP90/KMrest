package model;

import javax.persistence.*;


@Entity

public class Producer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id;


    private String producerName;

    public Producer() {
    }

    public int getId() {
        return id;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
}
