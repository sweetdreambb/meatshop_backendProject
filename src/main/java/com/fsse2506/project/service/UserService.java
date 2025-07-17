package com.fsse2506.project.service;

import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2506.project.data.user.entity.UserEntity;

public interface UserService {
    UserEntity getUserEntityByFirebaseUserData(FirebaseUserData firebaseUserData);
}
