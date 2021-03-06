package entities.orderitemtype;

import entities.ItemType;
import entities.Order;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "link_orders_itemType")
public class OrderItemType implements Serializable {

    private static final long serialVersionUID = 2817296919012720863L;

    @EmbeddedId
    private OrderItemTypeId id;

    @ManyToOne
    @MapsId("itemTypeId")
    @JoinColumn(name = "itemTypeId")
    private ItemType itemType;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "orderId")
    private Order order;

    @Column(name = "quantity")
    private int quantity;

    public OrderItemType(Order order, ItemType itemType, int quantity) {
        this.id = new OrderItemTypeId(order.getOrderId(), itemType.getItemTypeId());
        this.order = order;
        this.itemType = itemType;
        this.quantity = quantity;
    }

    public OrderItemType() {
    }

    public OrderItemTypeId getId() {
        return id;
    }

    public void setId(OrderItemTypeId id) {
        this.id = id;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItemType{" +
            "id=" + id +
            ", itemType=" + itemType +
            ", quantity=" + quantity +
            '}';
    }
}
