package bot.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Customer customer;
    private List<Product> products;

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Cart() {
        this.products = new ArrayList<>();
    }
}
