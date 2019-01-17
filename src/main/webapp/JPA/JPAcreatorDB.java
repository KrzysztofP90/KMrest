package JPA;

import model.Ammo;
import model.Calibre;
import model.FireArms;
import model.Producer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAcreatorDB {

    public static void initDataBase(EntityManager menager) {

        Calibre caliber12 = new Calibre();
        caliber12.setSize(12.5);

        Calibre caliber44 = new Calibre();
        caliber44.setSize(44.0);

        Ammo ammo1 = new Ammo();
        ammo1.setCalibre(caliber12);
        ammo1.setPrice(20.99);

        Ammo ammo2 = new Ammo();
        ammo2.setCalibre(caliber44);
        ammo2.setPrice(36.50);

        Producer winchester = new Producer();
        winchester.setProducerName("Winchester");

        Producer mihuCompany = new Producer();
        mihuCompany.setProducerName("Mihu-Company");

        FireArms glock = new FireArms();
        glock.setCalibre(caliber12);
        glock.setProducer(mihuCompany);
        glock.setName("Glock511-P");

        FireArms uzi = new FireArms();
        uzi.setName("UZI-152");
        uzi.setProducer(winchester);
        uzi.setCalibre(caliber44);

        menager.getTransaction().begin();

        menager.persist(caliber12);
        menager.persist(caliber44);

        menager.persist(ammo1);
        menager.persist(ammo2);

        menager.persist(winchester);
        menager.persist(mihuCompany);

        menager.persist(glock);
        menager.persist(uzi);

        menager.getTransaction().commit();


    }

    public static void main(String[] a ) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("REST");
        EntityManager menager = factory.createEntityManager();

        initDataBase(menager);


        menager.close();
        factory.close();

    }
}
