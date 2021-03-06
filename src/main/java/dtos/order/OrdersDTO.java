package dtos.order;

import entities.Order;
import java.util.List;

public class OrdersDTO {

    private List<OrderDTO> all;

    public OrdersDTO() {
    }

    public OrdersDTO(List<Order> all) {
        this.all = OrderDTO.getFromOrderList(all);
    }

    public List<OrderDTO> getAll() {
        return all;
    }

    public void setAll(List<OrderDTO> all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
            "all=" + all +
            '}';
    }
}
