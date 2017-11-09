package bot.db;

import bot.model.Customer;
import bot.model.Order;
import bot.model.Product;
import bot.model.ProductType;

import java.util.ArrayList;
import java.util.List;

public class DAO {

    public Customer getCustomerByAlias(String alias){
        return null;
    }

    public Customer getCustomerByPhone(String phone){
        return null;
    }

    public List<Order> getCustomersOrders(Customer customer){
        return new ArrayList<>();
    }

    public List<Product> getProducts(ProductType type){
        return new ArrayList<>();
    }

    public void saveOrder(Order order){

    }
}
