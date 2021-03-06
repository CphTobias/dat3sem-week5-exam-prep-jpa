package facades;

import dtos.customer.CustomerDTO;
import dtos.customer.CustomersDTO;
import entities.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CustomerFacade {

    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    public static CustomerFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        EntityManager em = emf.createEntityManager();
        Customer customer = new Customer(customerDTO);
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new CustomerDTO(customer);
    }

    public CustomerDTO getById(int customerId) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, customerId);
            return new CustomerDTO(customer);
        } finally {
            em.close();
        }
    }

    public CustomersDTO getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            List<Customer> customers = em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
            return new CustomersDTO(customers);
        } finally {
            em.close();
        }
    }

}
