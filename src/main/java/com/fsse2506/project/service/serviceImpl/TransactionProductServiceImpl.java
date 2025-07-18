package com.fsse2506.project.service.serviceImpl;

import com.fsse2506.project.data.cartItem.domainObject.response.CartItemResponseData;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.transaction.entity.TransactionEntity;
import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2506.project.mapper.transactionProduct.TransactionProductDataMapper;
import com.fsse2506.project.mapper.transactionProduct.TransactionProductEntityMapper;
import com.fsse2506.project.repository.TransactionProductRepository;
import com.fsse2506.project.service.ProductService;
import com.fsse2506.project.service.TransactionProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionProductServiceImpl implements TransactionProductService {
    private final TransactionProductEntityMapper transactionProductEntityMapper;
    private final ProductService productService;
    private final TransactionProductRepository transactionProductRepository;
    private final TransactionProductDataMapper transactionProductDataMapper;

    @Override
    @Transactional
    public List<TransactionProductResponseData> createTransactionProductResponseDataList(
            TransactionEntity transactionEntity
            , List<CartItemResponseData> cartItemResponseDataList
    ){
        //convert cartItemList to transactionProductEntityList
        List<TransactionProductEntity> transactionProductEntityList
                =transactionProductEntityMapper.toTransactionProductEntityList(
                cartItemResponseDataList,transactionEntity
        );
        //convert transactionProductEntityList to productEntityList
        List<ProductEntity> productEntityList=
                getProductEntityList(transactionProductEntityList);

        //update transactionProductionRepository
        transactionProductEntityList=
                (List<TransactionProductEntity>)transactionProductRepository
                        .saveAll(transactionProductEntityList);
        return transactionProductDataMapper.toTransactionProductResponseDataList(
                transactionProductEntityList,
                productService.getProductResponseDataList(
                        productEntityList
                )
        );
    }
    @Override
    public List<TransactionProductResponseData> getTransactionProductResposneDataList(
            TransactionEntity transactionEntity){
        List<TransactionProductEntity> transactionProductEntityList=
                transactionProductRepository.findAllByTransactionEntity(transactionEntity);
        //convert transactionProductEntityList to productEntityList
        return transactionProductDataMapper.toTransactionProductResponseDataList(
                transactionProductEntityList,
                productService.getProductResponseDataList(
                        getProductEntityList(transactionProductEntityList)
                )
        );
    }
    @Override
    public List<ProductEntity> getProductEntityList(List<TransactionProductEntity> transactionProductEntityList){
        //convert transactionProductEntityList to productEntityList
        List<ProductEntity> productEntityList=new ArrayList<>();
        for (TransactionProductEntity transactionProductEntity: transactionProductEntityList){
            productEntityList.add(
                    productService.getProductEntityByPid(
                            transactionProductEntity.getPid()
                    )
            );
        }
        return productEntityList;
    }
}
