package bot.controller;

import bot.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    private static List<Product> products = new ArrayList<>();
    public static Product getProductById(int id){
        for (Product product: products){
            if (product.getId() == id)
                return product;
        }
        return null;
    }
}
