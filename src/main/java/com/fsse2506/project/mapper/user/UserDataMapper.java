package com.fsse2506.project.mapper.user;

import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.oauth2.jwt.Jwt;

@Mapper(componentModel="spring")
public interface UserDataMapper {
    @Mapping(target="firebaseUid",expression = "java(jwt.getClaimAsString(\"user_id\"))")
    @Mapping(target="email",expression="java(jwt.getClaimAsString(\"email\"))")
    FirebaseUserData toFirebaseUserData(Jwt jwt);
//        firebaseUserData.setFirebaseUid(jwt.getClaimAsString("user_id"));
//        firebaseUserData.setEmail(jwt.getClaimAsString("email"));

}
