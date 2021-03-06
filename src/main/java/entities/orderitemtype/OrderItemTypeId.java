package entities.orderitemtype;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

@Embeddable
public class OrderItemTypeId implements Serializable {

    private static final long serialVersionUID = -2668820777214018307L;

    private Integer orderId;
    private Integer itemTypeId;

    public OrderItemTypeId(Integer orderId, Integer itemTypeId) {
        this.orderId = orderId;
        this.itemTypeId = itemTypeId;
    }

    public OrderItemTypeId() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderItemTypeId)) {
            return false;
        }
        OrderItemTypeId that = (OrderItemTypeId) o;
        return Objects.equals(getOrderId(), that.getOrderId()) && Objects
            .equals(getItemTypeId(), that.getItemTypeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getItemTypeId());
    }

    @Override
    public String toString() {
        return "OrderItemTypeId{" +
            "orderId=" + orderId +
            ", itemTypeId=" + itemTypeId +
            '}';
    }
}
