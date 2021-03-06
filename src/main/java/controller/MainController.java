package controller;

import dtos.ItemTypeDTO;
import dtos.OrderItemTypeDTO;
import dtos.order.OrderDTO;
import dtos.customer.CustomerDTO;
import dtos.customer.CustomersDTO;
import dtos.order.OrdersDTO;
import entities.Customer;
import facades.CustomerFacade;
import facades.ItemTypeFacade;
import facades.OrderFacade;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainController {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade customerFacade = CustomerFacade.getInstance(emf);
        ItemTypeFacade itemTypeFacade = ItemTypeFacade.getInstance(emf);
        OrderFacade orderFacade = OrderFacade.getInstance(emf);
        populator(emf.createEntityManager());

        //Create customer
        CustomerDTO createdCustomer = customerFacade.createCustomer(
            new CustomerDTO("Bob", "TheBuilder", "bob@thebuilder.com")
        );
        System.out.println("Created customer: " + createdCustomer);

        //Find a customer
        CustomerDTO foundCustomer = customerFacade.getById(createdCustomer.getId());
        System.out.println("Found customer: " + foundCustomer);

        //Get all customers
        CustomersDTO allCustomers = customerFacade.getAll();
        System.out.println("All customers: " + allCustomers);

        //Create an itemType
        ItemTypeDTO createdItemType = itemTypeFacade.createItemType(
            new ItemTypeDTO("Cola", "Soda", 20)
        );
        System.out.println("Created itemType: " + createdItemType);

        //Find an itemType
        ItemTypeDTO foundItemType = itemTypeFacade.getById(createdItemType.getId());
        System.out.println("Found itemType: " + foundItemType);

        //Creating an order with a customer
        ItemTypeDTO secondItemType = itemTypeFacade.createItemType(
            new ItemTypeDTO("Ale", "Beer", 40)
        );

        OrderDTO toCreate = new OrderDTO(createdCustomer);
        Map<Integer, ItemTypeDTO> itemsToAdd = new HashMap<>();
        itemsToAdd.put(4, createdItemType);
        itemsToAdd.put(10, secondItemType);

        OrderDTO createdOrderWithItems = orderFacade.createOrder(toCreate, itemsToAdd);
        System.out.println("Created order: " + createdOrderWithItems);

        OrdersDTO allFromCustomer = orderFacade.getAllFromCustomer(createdCustomer.getId());
        System.out.println(allFromCustomer);

        //Not sure if i can do this with jpql
        double totalPriceOfOrder = 0;
        for (OrderDTO order : allFromCustomer.getAll()) {
            for (OrderItemTypeDTO orderItem : order.getItemTypes()) {
                totalPriceOfOrder = totalPriceOfOrder + orderItem.getQuantity() * orderItem.getItemType().getPrice();
            }
        }

        System.out.println(totalPriceOfOrder);
    }

    public static void populator(EntityManager em) {
        try {
            em.getTransaction().begin();
            em.persist(new Customer("pop", "ulated", "pop@ulated.com"));
            em.persist(new Customer("pop", "ulated", "pop@ulated.com"));
            em.persist(new Customer("pop", "ulated", "pop@ulated.com"));
            em.persist(new Customer("pop", "ulated", "pop@ulated.com"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
