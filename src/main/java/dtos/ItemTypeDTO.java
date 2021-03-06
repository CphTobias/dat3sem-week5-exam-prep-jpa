package dtos;

import entities.ItemType;

public class ItemTypeDTO {

    private Integer id;
    private String name;
    private String description;
    private double price;

    public ItemTypeDTO(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ItemTypeDTO(ItemType itemType) {
        this.id = itemType.getItemTypeId();
        this.name = itemType.getName();
        this.description = itemType.getDescription();
        this.price = itemType.getPrice();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "ItemTypeDTO{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", price=" + price +
            '}';
    }
}
