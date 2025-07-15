package com.fsse2506.project.mapper.user;

import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

@Component
public class UserDataMapper {
    public FirebaseUserData toFirebaseUserData(Jwt jwt){
        FirebaseUserData firebaseUserData=new FirebaseUserData();
        firebaseUserData.setFirebaseUid(jwt.getClaimAsString("user_id"));
        firebaseUserData.setEmail(jwt.getClaimAsString("email"));
        return firebaseUserData;
    }
}
