package E_commerce.Sneaker.Service.Cart;

import E_commerce.Sneaker.dtos.CartDTO;
import E_commerce.Sneaker.model.Cart.Cart;

import java.util.List;

public interface CartService {
    List<CartDTO> findByUserId(Long userId);
    Cart addToCart(Cart cart);
    boolean removeFromCart(Long cartId);
    Cart updateCart(Cart cart);
}
