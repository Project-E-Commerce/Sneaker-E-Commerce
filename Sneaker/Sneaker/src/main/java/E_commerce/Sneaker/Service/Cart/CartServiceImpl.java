package E_commerce.Sneaker.Service.Cart;

import E_commerce.Sneaker.Service.Product.ProductService;
import E_commerce.Sneaker.dtos.CartDTO;
import E_commerce.Sneaker.model.Cart.Cart;
import E_commerce.Sneaker.model.Product.Product;
import E_commerce.Sneaker.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    @Override
    public List<CartDTO> findByUserId(Long userId) {
        List<Cart> carts = cartRepository.findByUserId(userId);
        List<CartDTO> cartDTOs = new ArrayList<>();

        for (Cart cart : carts) {
            Product product = productService.findById(cart.getProduct_id());
            CartDTO cartDTO = new CartDTO();
            cartDTO.setCart_id(cart.getCart_id());
            cartDTO.setUser_id(cart.getUser_id());
            cartDTO.setProduct_id(cart.getProduct_id());
            cartDTO.setQuantity(cart.getQuantity());
            cartDTO.setTotal_price(cart.getTotal_price());
            cartDTO.setProduct_name(product.getProduct_name());
            cartDTO.setProduct_price(product.getPrice());
            cartDTOs.add(cartDTO);
        }

        return cartDTOs;
    }

    @Override
    public Cart addToCart(Cart cart) {
        cart.setCreated_at(new Date());
        cart.setUpdated_at(new Date());
        return cartRepository.save(cart);
    }

    @Override
    public boolean removeFromCart(Long cartId) {
        if (cartRepository.existsById(cartId)) {
            cartRepository.deleteById(cartId);
            return true;
        }
        return false;
    }

    @Override
    public Cart updateCart(Cart cart) {
        if (cartRepository.existsById(cart.getCart_id())) {
            cart.setUpdated_at(new Date());
            return cartRepository.save(cart);
        }
        return null;
    }
}
