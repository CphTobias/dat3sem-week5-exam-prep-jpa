package dtos.customer;

import entities.Customer;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public static List<CustomerDTO> getFromCustomerList(List<Customer> customers) {
        return customers.stream()
            .map(customer -> new CustomerDTO(customer))
            .collect(Collectors.toList());
    }

    public CustomerDTO() {
    }

    public CustomerDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public CustomerDTO(Customer customer) {
        this.id = customer.getCustomerId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "CustomerDTO{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}
