package com.fsse2506.project.controller;

import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2506.project.mapper.user.UserDataMapper;
import com.fsse2506.project.service.CartItemService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart/items")
public class CartItemController {
    private final UserDataMapper userDataMapper;
    private final CartItemService cartItemService;

    public CartItemController(UserDataMapper userDataMapper, CartItemService cartItemService) {
        this.userDataMapper = userDataMapper;
        this.cartItemService = cartItemService;
    }

    @PutMapping("/{pid}/{quantity}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putCartItem(@PathVariable Integer pid, @PathVariable Integer quantity, @AuthenticationPrincipal Jwt jwt){
        cartItemService.putCartItem(
                pid
                ,quantity
                ,userDataMapper.toFirebaseUserData(jwt)
        );
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductEntity getCartItem(@AuthenticationPrincipal Jwt jwt){

    }
}
