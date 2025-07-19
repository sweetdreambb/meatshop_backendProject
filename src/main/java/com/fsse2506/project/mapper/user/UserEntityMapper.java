package com.fsse2506.project.mapper.user;

import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2506.project.data.user.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserEntityMapper {
    UserEntity toUserEntity(FirebaseUserData firebaseUserData);
}
