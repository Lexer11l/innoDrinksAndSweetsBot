package bot.model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Customer customer;
    private Map<Product, Integer> products;

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Order() {
        this.products = new HashMap<>();
    }
}
