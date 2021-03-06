package entities;

import entities.orderitemtype.OrderItemType;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-03-06T17:51:50", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(ItemType.class)
public class ItemType_ { 

    public static volatile SingularAttribute<ItemType, Double> price;
    public static volatile SingularAttribute<ItemType, String> name;
    public static volatile SingularAttribute<ItemType, String> description;
    public static volatile ListAttribute<ItemType, OrderItemType> orders;
    public static volatile SingularAttribute<ItemType, Integer> itemTypeId;

}