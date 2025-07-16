package com.fsse2506.project.service.serviceImpl;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2506.project.data.cartItem.entity.CartItemEntity;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2506.project.data.user.entity.UserEntity;
import com.fsse2506.project.exception.ProductExceedStockException;
import com.fsse2506.project.exception.ProductNotFoundException;
import com.fsse2506.project.exception.UpdateProductQuantityNegativeException;
import com.fsse2506.project.mapper.cartItem.CartItemDataMapper;
import com.fsse2506.project.mapper.cartItem.CartItemEntityMapper;
import com.fsse2506.project.repository.CartItemRepository;
import com.fsse2506.project.service.CartItemService;
import com.fsse2506.project.service.ProductService;
import com.fsse2506.project.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;
    private final ProductService productService;
    private final CartItemEntityMapper cartItemEntityMapper;
    private final CartItemRepository cartItemRepository;
    private final CartItemDataMapper cartItemDataMapper;
    private final Logger logger= LoggerFactory.getLogger(CartItemServiceImpl.class);


    public CartItemServiceImpl(UserService userService, ProductService productService, CartItemEntityMapper cartItemEntityMapper, CartItemRepository cartItemRepository, CartItemDataMapper cartItemDataMapper) {
        this.userService = userService;
        this.productService = productService;
        this.cartItemEntityMapper = cartItemEntityMapper;
        this.cartItemRepository = cartItemRepository;
        this.cartItemDataMapper = cartItemDataMapper;
    }
    @Override
    public void putCartItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData){
        try {
            Integer stock = productService.getProductByPid(pid).getStock();
            if (quantity > stock) {
                throw new ProductExceedStockException(stock);
            }
            cartItemRepository.save(
                    cartItemEntityMapper.toCartItemEntity(
                            quantity
                            , userService.getUserEntityByEmail(firebaseUserData)
                            , productService.getProductEntityByPid(pid)
                    )
            );
        } catch (Exception ex){
            logger.warn("Add item to cart failed: {}", ex.getMessage());
            throw ex;
        }
    }
    @Override
    public List<CartItemResponseData> getAllCartItem(FirebaseUserData firebaseUserData){
        return cartItemDataMapper.toCartItemResponseDataList(
                cartItemRepository.findByUserEntity(
                        userService.getUserEntityByEmail(firebaseUserData)
                )
        );
    }
    @Override
    public void updateCartQuantity(FirebaseUserData firebaseUserData, Integer pid, Integer quantity) {
        try {
            if (quantity < 0) {
                throw new UpdateProductQuantityNegativeException(quantity);
            }

            CartItemEntity cartItemEntity = getCartItemEntity(
                    userService.getUserEntityByEmail(firebaseUserData)
                    , productService.getProductEntityByPid(pid)
            );
            cartItemEntity.setQuantity(quantity);
            cartItemRepository.save(cartItemEntity);
        } catch (Exception ex) {
            logger.warn("Update Cart Quantity failed: {}", ex.getMessage());
            throw ex;
        }
    }
    @Override
    public void removeCartItem(FirebaseUserData firebaseUserData, Integer pid){
        try{
            cartItemRepository.delete(getCartItemEntity(
                    userService.getUserEntityByEmail(firebaseUserData)
                    , productService.getProductEntityByPid(pid)));
        }catch (Exception ex){
            logger.warn("Remove Cart Item failed: {}",ex.getMessage());
            throw ex;
        }
    }
    public CartItemEntity getCartItemEntity(UserEntity userEntity, ProductEntity productEntity){
        return cartItemRepository.findByUserEntityAndProductEntity(
                userEntity
                ,productEntity
        ).orElseThrow(
                () -> new ProductNotFoundException(
                        productEntity.getPid()
                )
        );
    }
}
