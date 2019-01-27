package model;

import javax.persistence.*;


@Entity

public class Producer implements Model {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private long id;

    private String producerName;

    public Producer() {
    }

    public long getId() {
        return id;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
}
