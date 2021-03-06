package entities.orderitemtype;

import entities.ItemType;
import entities.Order;
import entities.orderitemtype.OrderItemTypeId;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-03-06T16:25:42", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(OrderItemType.class)
public class OrderItemType_ { 

    public static volatile SingularAttribute<OrderItemType, ItemType> itemType;
    public static volatile SingularAttribute<OrderItemType, Integer> quantity;
    public static volatile SingularAttribute<OrderItemType, OrderItemTypeId> id;
    public static volatile SingularAttribute<OrderItemType, Order> order;

}