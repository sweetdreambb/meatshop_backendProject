package com.fsse2506.project.service.serviceImpl;

import com.fsse2506.project.data.cartItem.entity.CartItemEntity;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2506.project.data.user.entity.UserEntity;
import com.fsse2506.project.mapper.cartItem.CartItemEntityMapper;
import com.fsse2506.project.repository.CartItemRepository;
import com.fsse2506.project.service.CartItemService;
import com.fsse2506.project.service.ProductService;
import com.fsse2506.project.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;
    private final ProductService productService;
    private final CartItemEntityMapper cartItemEntityMapper;
    private final CartItemRepository cartItemRepository;


    public CartItemServiceImpl(UserService userService, ProductService productService, CartItemEntityMapper cartItemEntityMapper, CartItemRepository cartItemRepository) {
        this.userService = userService;
        this.productService = productService;
        this.cartItemEntityMapper = cartItemEntityMapper;
        this.cartItemRepository = cartItemRepository;
    }
    @Override
    public void putCartItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData){
        cartItemRepository.save(
                cartItemEntityMapper.toCartItemEntity(
                        quantity
                        ,userService.getUserEntityByEmail(firebaseUserData)
                        ,productService.getProductEntityByPid(pid)
                )
        );
    }
    @Override
    public List<CartItemResponseData> getCartItem(FirebaseUserData firebaseUserData){
        UserEntity userEntity=userService.getUserEntityByEmail(firebaseUserData);
    }
}
