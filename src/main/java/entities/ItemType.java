package entities;

import dtos.ItemTypeDTO;
import entities.orderitemtype.OrderItemType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "itemType")
public class ItemType implements Serializable {

    private static final long serialVersionUID = 1217590574390991065L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemTypeId")
    private Integer itemTypeId;

    @Column(
        name = "name",
        nullable = false,
        unique = true
    )
    private String name;

    @Column(
        name = "description",
        nullable = false
    )
    private String description;

    @Column(
        name = "price",
        nullable = false
    )
    private double price;

    @OneToMany(
        mappedBy = "itemType",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<OrderItemType> orders;

    public ItemType() {
    }

    public ItemType(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.orders = new ArrayList<>();
    }

    public ItemType(ItemTypeDTO itemTypeDTO) {
        this.name = itemTypeDTO.getName();
        this.description = itemTypeDTO.getDescription();
        this.price = itemTypeDTO.getPrice();
        this.orders = new ArrayList<>();
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<OrderItemType> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderItemType> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "ItemTypeDTO{" +
            "itemTypeId=" + itemTypeId +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", price=" + price +
            '}';
    }
}
