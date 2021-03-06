package entities;

import dtos.order.OrderDTO;
import entities.orderitemtype.OrderItemType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 3327094574133842986L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(
        mappedBy = "order",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderItemType> itemTypes;

    public Order() {
    }

    public Order(Customer customer) {
        this.customer = customer;
        this.itemTypes = new ArrayList<>();
    }

    public Order(OrderDTO orderDTO) {
        this.customer = new Customer(orderDTO.getCustomer());
        this.itemTypes = new ArrayList<>();
    }

    public void addItemType(ItemType itemType, int quantity) {
        if (itemType != null) {
            OrderItemType orderItemType = new OrderItemType(this, itemType, quantity);
            this.itemTypes.add(orderItemType);
            itemType.getOrders().add(orderItemType);
        }
    }

    public void removeItemType(ItemType itemType) {
        Iterator<OrderItemType> iterator = itemTypes.iterator();

        while (iterator.hasNext()) {
            OrderItemType pt = iterator.next();
            if (pt.getOrder().equals(this) && pt.getItemType().equals(itemType)){
                iterator.remove();
                pt.getItemType().getOrders().remove(pt);
            }

        }
    }


    public void setOrderId(Integer id) {
        this.orderId = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItemType> getItemTypes() {
        return itemTypes;
    }

    @Override
    public String toString() {
        return "Order{" +
            "orderId=" + orderId +
            ", customer=" + customer +
            ", itemTypes=" + itemTypes +
            '}';
    }
}
