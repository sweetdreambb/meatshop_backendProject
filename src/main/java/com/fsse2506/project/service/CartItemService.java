package com.fsse2506.project.service;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;

import java.util.List;

public interface CartItemService {


    void putCartItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData);

    List<CartItemResponseData> getAllCartItem(FirebaseUserData firebaseUserData);

    void updateCartQuantity(FirebaseUserData firebaseUserData, Integer pid, Integer quantity);

    void removeCartItem(FirebaseUserData firebaseUserData, Integer pid);
}
