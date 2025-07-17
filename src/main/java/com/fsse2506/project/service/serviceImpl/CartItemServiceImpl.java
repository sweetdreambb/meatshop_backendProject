package com.fsse2506.project.service.serviceImpl;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2506.project.data.cartItem.entity.CartItemEntity;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2506.project.data.user.entity.UserEntity;
import com.fsse2506.project.exception.cartItem.CartItemDeleteFailException;
import com.fsse2506.project.exception.cartItem.CartItemExceedStockException;
import com.fsse2506.project.exception.cartItem.CartItemNotFoundException;
import com.fsse2506.project.mapper.cartItem.CartItemDataMapper;
import com.fsse2506.project.mapper.cartItem.CartItemEntityMapper;
import com.fsse2506.project.repository.CartItemRepository;
import com.fsse2506.project.service.CartItemService;
import com.fsse2506.project.service.ProductService;
import com.fsse2506.project.service.UserService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Transactional
    public void putCartItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData){
        try {
            UserEntity userEntity=userService.getUserEntityByFirebaseUserData(firebaseUserData);
            ProductEntity productEntity=productService.getProductEntityByPid(pid);
            Optional<CartItemEntity> cartItemEntityOptional=
                    cartItemRepository.findByUserEntityAndProductEntity(userEntity,productEntity);
            //cart item not exist, add new cart item
            if (cartItemEntityOptional.isEmpty()){
                if (quantity>productEntity.getStock()){
                    throw new CartItemExceedStockException(pid);
                }
                cartItemRepository.save(
                        cartItemEntityMapper.toCartItemEntity(
                                quantity,userEntity,productEntity
                        )
                );
            } else {
                // cart item exists, check stock availability
                CartItemEntity cartItemEntity=cartItemEntityOptional.get();
                if (cartItemEntity.getQuantity()+quantity > productEntity.getStock()) {
                    throw new CartItemExceedStockException(pid);
                }
                cartItemEntity.setQuantity(cartItemEntity.getQuantity()+quantity);
            }
        } catch (Exception ex){
            logger.warn("Add item to cart failed: {}", ex.getMessage());
            throw ex;
        }
    }
    @Override
    public List<CartItemResponseData> getUserCart(FirebaseUserData firebaseUserData){
        return cartItemDataMapper.toCartItemResponseDataList(
                cartItemRepository.findByUserEntity(
                        userService.getUserEntityByFirebaseUserData(firebaseUserData)
                )
        );
    }
    @Override
    @Transactional
    public void updateCartQuantity(FirebaseUserData firebaseUserData, Integer pid, Integer quantity) {
        try {
            UserEntity userEntity=userService.getUserEntityByFirebaseUserData(firebaseUserData);
            ProductEntity productEntity=productService.getProductEntityByPid(pid);
            CartItemEntity cartItemEntity = getCartItemEntity(
                    userEntity
                    , productEntity
            );
            // check stock
            if(productEntity.getStock()<quantity){
                throw new CartItemExceedStockException(pid);
            }
            cartItemEntity.setQuantity(quantity);
            cartItemRepository.save(cartItemEntity);
        } catch (Exception ex) {
            logger.warn("Update Cart Quantity failed: {}", ex.getMessage());
            throw ex;
        }
    }
    @Override
    @Transactional
    public void removeCartItem(FirebaseUserData firebaseUserData, Integer pid){
        try{
            String email= firebaseUserData.getEmail();
            Integer result=
                    cartItemRepository.deleteByUserEntity_EmailAndProductEntity_Pid(
                            email, pid
                    );
            if (result==0){
                throw new CartItemDeleteFailException(email, pid);
            }
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
                () -> new CartItemNotFoundException(
                        userEntity.getUid(),productEntity.getPid()
                )
        );
    }

}
