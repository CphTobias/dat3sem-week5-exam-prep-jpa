package dtos.order;

import dtos.OrderItemTypeDTO;
import dtos.customer.CustomerDTO;
import entities.Order;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDTO {

    private Integer id;
    private CustomerDTO customer;
    private List<OrderItemTypeDTO> itemTypes;

    public static List<OrderDTO> getFromOrderList(List<Order> orders) {
        return orders.stream()
            .map(order -> new OrderDTO(order))
            .collect(Collectors.toList());
    }

    public OrderDTO(Order order) {
        this.id = order.getOrderId();
        this.customer = new CustomerDTO(order.getCustomer());
        this.itemTypes = OrderItemTypeDTO.getFromList(order.getItemTypes());
    }

    public OrderDTO() {
    }

    public OrderDTO(CustomerDTO customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<OrderItemTypeDTO> getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(List<OrderItemTypeDTO> itemTypes) {
        this.itemTypes = itemTypes;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
            "id=" + id +
            ", customer=" + customer +
            ", itemTypes=" + itemTypes +
            '}';
    }
}
