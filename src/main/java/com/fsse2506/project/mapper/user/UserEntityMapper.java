package com.fsse2506.project.mapper.user;

import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2506.project.data.user.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {
    public UserEntity toUserEntity(FirebaseUserData firebaseUserData){
        UserEntity userEntity=new UserEntity();
        userEntity.setEmail(firebaseUserData.getEmail());
        userEntity.setFirebaseUid(firebaseUserData.getFirebaseUid());
        return userEntity;
    }
}
