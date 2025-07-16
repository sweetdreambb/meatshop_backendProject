package com.fsse2506.project.controller;

import com.fsse2506.project.data.cartItem.dto.response.CartItemResponseDto;
import com.fsse2506.project.mapper.cartItem.CartItemDtoMapper;
import com.fsse2506.project.mapper.user.UserDataMapper;
import com.fsse2506.project.service.CartItemService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart/items")
public class CartItemController {
    private final UserDataMapper userDataMapper;
    private final CartItemService cartItemService;
    private final CartItemDtoMapper cartItemDtoMapper;

    public CartItemController(UserDataMapper userDataMapper, CartItemService cartItemService, CartItemDtoMapper cartItemDtoMapper) {
        this.userDataMapper = userDataMapper;
        this.cartItemService = cartItemService;
        this.cartItemDtoMapper = cartItemDtoMapper;
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
    public List<CartItemResponseDto> getAllCartItem(@AuthenticationPrincipal Jwt jwt){
        return cartItemDtoMapper.toCartItemResponseDtoList(
                cartItemService.getAllCartItem(
                        userDataMapper.toFirebaseUserData(jwt)
                )
        );
    }
    @PatchMapping("/{pid}/{quantity}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCartQuantity(@AuthenticationPrincipal Jwt jwt,@PathVariable Integer pid, @PathVariable Integer quantity){
        cartItemService.updateCartQuantity(userDataMapper.toFirebaseUserData(jwt),pid,quantity);
    }
    @DeleteMapping("/{pid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCartItem(@AuthenticationPrincipal Jwt jwt, @PathVariable Integer pid){
        cartItemService.removeCartItem(userDataMapper.toFirebaseUserData(jwt),pid);
    }
}
