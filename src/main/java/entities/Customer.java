package entities;

import dtos.customer.CustomerDTO;
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
@Table(name = "customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Integer customerId;

    @Column(
        name = "firstName",
        nullable = false,
        length = 50
    )
    private String firstName;

    @Column(
        name = "lastName",
        nullable = false,
        length = 50
    )
    private String lastName;

    @Column(
        name = "email",
        nullable = false,
        length = 100
    )
    private String email;

    @OneToMany(
        cascade = CascadeType.PERSIST,
        mappedBy = "customer"
    )
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public Customer(CustomerDTO customerDTO) {
        this.firstName = customerDTO.getFirstName();
        this.lastName = customerDTO.getLastName();
        this.email = customerDTO.getEmail();
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        if (order != null) {
            this.orders.add(order);
            order.setCustomer(this);
        }
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer id) {
        this.customerId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "customerId=" + customerId +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            '}';
    }


}
