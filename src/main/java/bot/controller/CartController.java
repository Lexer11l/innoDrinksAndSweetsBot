package bot.controller;

import bot.model.Cart;
import bot.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartController {
    private static List<Cart> userCarts = new ArrayList<>();

    public static void addProductToCart(String alias, int id){
        Cart cart = getCartWithId(alias);
        if (cart == null) cart = new Cart();
        Product product = ProductController.getProductById(id);
        cart.getProducts().add(product);
    }

    public static void clearCart(){
        userCarts.clear();
    }

    public static List<Cart> showCart(){
        return userCarts;
    }

    private static Cart getCartWithId(String alias){
        for (Cart cart: userCarts){
            if (cart.getCustomer().getUserAlias().equals(alias))
                return cart;
        }
        return null;
    }

}
