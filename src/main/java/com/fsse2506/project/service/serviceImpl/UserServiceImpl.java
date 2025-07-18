package com.fsse2506.project.service.serviceImpl;

import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2506.project.data.user.entity.UserEntity;
import com.fsse2506.project.mapper.user.UserEntityMapper;
import com.fsse2506.project.repository.UserRepository;
import com.fsse2506.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public UserEntity getUserEntityByFirebaseUserData(FirebaseUserData firebaseUserData){

        return userRepository.findByEmail(firebaseUserData.getEmail())
                .orElseGet(() -> userRepository.save(
                        userEntityMapper.toUserEntity(firebaseUserData)
                )
        );
    }
}
