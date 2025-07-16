package com.fsse2506.project.service.serviceImpl;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;

import com.fsse2506.project.data.transaction.domainObject.response.TransactionResponseData;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;

import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2506.project.data.user.entity.UserEntity;
import com.fsse2506.project.mapper.transaction.TransactionDataMapper;
import com.fsse2506.project.repository.TransactionRepository;
import com.fsse2506.project.service.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final UserService userService;
    private final TransactionRepository transactionRepository;
    private final TransactionProductService transactionProductService;
    private final TransactionDataMapper transactionDataMapper;
    private final CartItemService cartItemService;

    public TransactionServiceImpl(UserService userService, TransactionRepository transactionRepository, TransactionProductService transactionProductService, TransactionDataMapper transactionDataMapper, CartItemService cartItemService) {
        this.userService = userService;
        this.transactionRepository = transactionRepository;
        this.transactionProductService = transactionProductService;
        this.transactionDataMapper = transactionDataMapper;
        this.cartItemService = cartItemService;
    }

    @Override
    public TransactionResponseData createTransaction(
            FirebaseUserData firebaseUserData){

        UserEntity userEntity=
                userService.getUserEntityByEmail(firebaseUserData);

        List<CartItemResponseData> cartItemResponseDataList=
                cartItemService.getAllCartItem(firebaseUserData);

        BigDecimal total=BigDecimal.ZERO;
        for (CartItemResponseData cartItemResponseData: cartItemResponseDataList){
            BigDecimal quantity=BigDecimal.valueOf(cartItemResponseData.getCartQuantity());
            BigDecimal price=cartItemResponseData.getPrice();
            total=total.add(quantity.multiply(price));
        }

        TransactionEntity transactionEntity=new TransactionEntity();
        transactionEntity.setUserEntity(userEntity);
        transactionEntity.setDatetime(LocalDateTime.now());
        transactionEntity.setStatus("PREPARE");
        transactionEntity.setTotal(total);
        transactionRepository.save(transactionEntity);
        return transactionDataMapper.toTransactionResponseData(
                transactionEntity,transactionProductService.createTransactionProductResponseDataList(
                        transactionEntity,
                        cartItemResponseDataList
                )
        );
    }

}
