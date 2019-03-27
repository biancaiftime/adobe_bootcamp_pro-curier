package service;

import com.procourier.model.Order;
import com.procourier.model.Product;
import dao.OrderDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OrderService {
    private EntityManagerFactory emf;

    private OrderService() {
        this.emf = Persistence.createEntityManagerFactory("pro-courierPU");
    }

    private final static class SingletonHolder {
        private static final OrderService instance = new OrderService();
    }

    public static OrderService getInstance() {
        return SingletonHolder.instance;
    }

    public void addOrder(Order order) {
        EntityManager em = emf.createEntityManager();
        OrderDao orderDao = new OrderDao(em);
        //orice modificare de INSERT, DELETE, UPDATE se fae intr-o tranzactie
        em.getTransaction().begin();
        orderDao.addOrder(order);
        em.getTransaction().commit();
    }

    public void addProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        OrderDao orderDao = new OrderDao(em);
        //orice modificare de INSERT, DELETE, UPDATE se fae intr-o tranzactie
        em.getTransaction().begin();
        orderDao.addProduct(product);
        em.getTransaction().commit();
    }

}
