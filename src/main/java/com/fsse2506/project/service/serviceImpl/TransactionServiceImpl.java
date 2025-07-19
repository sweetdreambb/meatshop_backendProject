package com.fsse2506.project.service.serviceImpl;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;

import com.fsse2506.project.data.transaction.domainObject.response.TransactionResponseData;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;

import com.fsse2506.project.data.transaction.status.Status;
import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import com.fsse2506.project.data.user.domainObject.request.FirebaseUserData;
import com.fsse2506.project.data.user.entity.UserEntity;
import com.fsse2506.project.exception.transaction.TransactionNotFoundException;
import com.fsse2506.project.exception.transaction.TransactionStatusNotPrepareException;
import com.fsse2506.project.exception.transaction.TransactionStatusNotProcessingException;
import com.fsse2506.project.mapper.transaction.TransactionDataMapper;
import com.fsse2506.project.repository.TransactionRepository;
import com.fsse2506.project.service.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {
    private final UserService userService;
    private final TransactionRepository transactionRepository;
    private final TransactionProductService transactionProductService;
    private final TransactionDataMapper transactionDataMapper;
    private final CartItemService cartItemService;
    private final Logger logger= LoggerFactory.getLogger(TransactionServiceImpl.class);
    private final ProductService productService;

    @Override
    @Transactional
    public TransactionResponseData createTransaction(
            FirebaseUserData firebaseUserData){

        UserEntity userEntity=
                userService.getUserEntityByFirebaseUserData(firebaseUserData);

        List<CartItemResponseData> cartItemResponseDataList=
                cartItemService.getUserCart(firebaseUserData);

        BigDecimal total=BigDecimal.ZERO;
        for (CartItemResponseData cartItemResponseData: cartItemResponseDataList){
            BigDecimal quantity=BigDecimal.valueOf(cartItemResponseData.getCartQuantity());
            BigDecimal price=cartItemResponseData.getPrice();
            total=total.add(quantity.multiply(price));
        }
        TransactionEntity transactionEntity=new TransactionEntity();
        transactionEntity.setUserEntity(userEntity);
        transactionEntity.setDatetime(LocalDateTime.now());
        transactionEntity.setStatus(Status.PREPARE);
        transactionEntity.setTotal(total);
        transactionEntity=transactionRepository.save(transactionEntity);

        List<TransactionProductResponseData> transactionProductResponseDataList
                =transactionProductService
                .createTransactionProductResponseDataList(
                        transactionEntity,
                        cartItemResponseDataList
                );
        for (TransactionProductResponseData transactionProductResponseData:
                transactionProductResponseDataList){
            cartItemService.removeCartItem(
                    firebaseUserData
                    ,transactionProductResponseData.getProductResponseData().getPid()
            );
        }
        return transactionDataMapper.toTransactionResponseData(
                transactionEntity,
                transactionProductResponseDataList
        );
    }
    @Override
    public TransactionResponseData getTransactionById(FirebaseUserData firebaseUserData, Integer tid){
        UserEntity userEntity = userService.getUserEntityByFirebaseUserData(firebaseUserData);

        Optional<TransactionEntity> transactionEntityOptional =
                transactionRepository.findByUserEntityAndTid(userEntity, tid);

        if (transactionEntityOptional.isEmpty()) {
            throw new TransactionNotFoundException(tid);
        }
        return transactionDataMapper.toTransactionResponseData(
                transactionEntityOptional.get(),
                transactionProductService.getTransactionProductResponseDataList(
                        transactionEntityOptional.get()
                )
        );
    }

    @Override
    @Transactional
    public void updateTransactionStatusProcessing(FirebaseUserData firebaseUserData, Integer tid){
        try {
            Optional<TransactionEntity> transactionEntityOptional =
                    transactionRepository.findByUserEntityAndTid(
                            userService.getUserEntityByFirebaseUserData(firebaseUserData)
                            , tid
                    );
            if (transactionEntityOptional.isEmpty()) {
                throw new TransactionNotFoundException(tid);
            }
            //check transaction status
            if (transactionEntityOptional.get().getStatus().equals(Status.PREPARE)) {
                //check stock availability and deduct stock
                productService.paymentProcessingAndDeductStock(
                        transactionProductService.getTransactionProductResponseDataList(
                                transactionEntityOptional.get()
                        )
                );
                transactionEntityOptional.get().setStatus(Status.PROCESSING);
            } else{
                throw new TransactionStatusNotPrepareException(transactionEntityOptional.get().getStatus());
            }
        } catch (Exception ex) {
            logger.warn("Update Transaction Status to Processing Failed: {}",ex.getMessage());
            throw ex;
        }
    }
    @Override
    @Transactional
    public TransactionResponseData updateTransactionStatusSuccess(FirebaseUserData firebaseUserData, Integer tid) {
        try {
            Optional<TransactionEntity> transactionEntityOptional =
                    transactionRepository.findByUserEntityAndTid(
                            userService.getUserEntityByFirebaseUserData(firebaseUserData)
                            , tid
                    );
            if (transactionEntityOptional.isEmpty()) {
                throw new TransactionNotFoundException(tid);
            }
            //check transaction status
            if (transactionEntityOptional.get().getStatus().equals(Status.PROCESSING)) {
                transactionEntityOptional.get().setStatus(Status.SUCCESS);
            } else{
                throw new TransactionStatusNotProcessingException(transactionEntityOptional.get().getStatus());
            }
            return transactionDataMapper.toTransactionResponseData(
                    transactionEntityOptional.get(),
                    transactionProductService.getTransactionProductResponseDataList(
                            transactionEntityOptional.get()
                    )
            );
        } catch (Exception ex) {
            logger.warn("Update Transaction Status to Success Failed: {}",ex.getMessage());
            throw ex;
        }
    }
}
