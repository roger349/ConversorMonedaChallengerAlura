package org.rer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class serviciosBD {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppConversorM");
    private final EntityManager manager = emf.createEntityManager();

    public void insertarDatos(Historial_de_Conversiones hc){

        manager.getTransaction().begin();
        manager.persist(hc);
        manager.getTransaction().commit();
    }
}
