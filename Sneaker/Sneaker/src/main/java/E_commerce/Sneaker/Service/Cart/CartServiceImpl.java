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
        List<Cart> carts = cartRepository.findByUserUserId(userId);
        List<CartDTO> cartDTOs = new ArrayList<>();

        for (Cart cart : carts) {
            Product product = productService.findById(cart.getProduct().getProductId());
            CartDTO cartDTO = new CartDTO();
            cartDTO.setCart_id(cart.getCartId());
            cartDTO.setUser_id(cart.getUser().getUserId());
            cartDTO.setProduct_id(cart.getProduct().getProductId());
            cartDTO.setQuantity(cart.getQuantity());
            cartDTO.setTotal_price(cart.getTotalPrice());
            cartDTO.setProduct_name(product.getProductName());
            cartDTO.setProduct_price(product.getPrice());
            cartDTOs.add(cartDTO);
        }

        return cartDTOs;
    }

    @Override
    public Cart addToCart(Cart cart) {
        cart.setCreatedAt(new Date());
        cart.setUpdatedAt(new Date());
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
        if (cartRepository.existsById(cart.getCartId())) {
            cart.setUpdatedAt(new Date());
            return cartRepository.save(cart);
        }
        return null;
    }
}
