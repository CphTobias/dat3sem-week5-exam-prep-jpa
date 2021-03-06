package dtos;

import entities.orderitemtype.OrderItemType;
import java.util.List;
import java.util.stream.Collectors;

public class OrderItemTypeDTO {

    private Integer quantity;
    private ItemTypeDTO itemType;

    public static List<OrderItemTypeDTO> getFromList(List<OrderItemType> orderItemTypes) {
        return orderItemTypes.stream()
            .map(oit -> new OrderItemTypeDTO(oit.getQuantity(), new ItemTypeDTO(oit.getItemType())))
            .collect(Collectors.toList());
    }

    public OrderItemTypeDTO(Integer quantity, ItemTypeDTO itemType) {
        this.quantity = quantity;
        this.itemType = itemType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ItemTypeDTO getItemType() {
        return itemType;
    }

    public void setItemTypes(ItemTypeDTO itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "OrderItemTypeDTO{" +
            "quantity=" + quantity +
            ", itemTypes=" + itemType +
            '}';
    }
}
