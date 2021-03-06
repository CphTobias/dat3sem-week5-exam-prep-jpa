package entities;

import entities.Customer;
import entities.orderitemtype.OrderItemType;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-03-06T17:51:50", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile ListAttribute<Order, OrderItemType> itemTypes;
    public static volatile SingularAttribute<Order, Integer> orderId;
    public static volatile SingularAttribute<Order, Customer> customer;

}