package dtos.customer;

import entities.Customer;
import java.util.List;

public class CustomersDTO {

    private List<CustomerDTO> all;

    public CustomersDTO() {
    }

    public CustomersDTO(List<Customer> customers) {
        this.all = CustomerDTO.getFromCustomerList(customers);
    }

    public List<CustomerDTO> getAll() {
        return all;
    }

    public void setAll(List<CustomerDTO> all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "CustomersDTO{" +
            "all=" + all +
            '}';
    }
}
