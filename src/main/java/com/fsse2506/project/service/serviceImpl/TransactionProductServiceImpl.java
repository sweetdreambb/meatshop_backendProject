package com.fsse2506.project.service.serviceImpl;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2506.project.data.cartItem.entity.CartItemEntity;
import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2506.project.mapper.transactionProduct.TransactionProductDataMapper;
import com.fsse2506.project.mapper.transactionProduct.TransactionProductEntityMapper;
import com.fsse2506.project.repository.TransactionProductRepository;
import com.fsse2506.project.service.ProductService;
import com.fsse2506.project.service.TransactionProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionProductServiceImpl implements TransactionProductService {
    private final TransactionProductEntityMapper transactionProductEntityMapper;
    private final ProductService productService;
    private final TransactionProductRepository transactionProductRepository;
    private final TransactionProductDataMapper transactionProductDataMapper;

    public TransactionProductServiceImpl(TransactionProductEntityMapper transactionProductEntityMapper, ProductService productService, TransactionProductRepository transactionProductRepository, TransactionProductDataMapper transactionProductDataMapper) {
        this.transactionProductEntityMapper = transactionProductEntityMapper;
        this.productService = productService;
        this.transactionProductRepository = transactionProductRepository;
        this.transactionProductDataMapper = transactionProductDataMapper;
    }
    @Override
    public List<TransactionProductResponseData> createTransactionProductResponseDataList(TransactionEntity transactionEntity, List<CartItemResponseData> cartItemResponseDataList){
        List<TransactionProductEntity> transactionProductEntityList=transactionProductEntityMapper.toTransactionProductEntityList(
                cartItemResponseDataList,transactionEntity
        );
        transactionProductRepository.saveAll(transactionProductEntityList);
        return transactionProductDataMapper.toTransactionProductResponseDataList(
                transactionProductEntityList,
                productService.getProductResponseDataList(transactionProductEntityList)
        );
    }
}
