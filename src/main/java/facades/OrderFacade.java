package facades;

import dtos.ItemTypeDTO;
import dtos.order.OrderDTO;
import dtos.order.OrdersDTO;
import entities.Customer;
import entities.ItemType;
import entities.Order;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class OrderFacade {

    private static EntityManagerFactory emf;
    private static OrderFacade instance;

    public static OrderFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            instance = new OrderFacade();
            emf = _emf;
        }
        return instance;
    }

    public OrderDTO createOrder(OrderDTO orderDTO, Map<Integer, ItemTypeDTO> itemTypes) {
        EntityManager em = emf.createEntityManager();
        Customer customer = em.find(Customer.class, orderDTO.getCustomer().getId());
        Order order = new Order(customer);

        itemTypes.forEach((amount, itemType) -> {
            ItemType itemTypeToAdd = new ItemType(itemType);
            itemTypeToAdd.setItemTypeId(itemType.getId());
            order.addItemType(itemTypeToAdd, amount);
        });

        try {
            em.getTransaction().begin();
            customer.addOrder(order);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new OrderDTO(order);
    }

    public OrdersDTO getAllFromCustomer(int customerId) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Order> orders = em.createQuery("SELECT o FROM Order o WHERE o.customer.customerId = :customerId", Order.class)
                .setParameter("customerId", customerId)
                .getResultList();
            return new OrdersDTO(orders);
        } finally {
            em.close();
        }
    }
}
