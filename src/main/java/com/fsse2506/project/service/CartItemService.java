package com.fsse2506.project.service;

import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;

public interface CartItemService {


    void putCartItem(Integer pid, Integer quantity, FirebaseUserData firebaseUserData);
}
