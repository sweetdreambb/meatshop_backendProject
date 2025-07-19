package com.fsse2506.project.service;

import com.fsse2506.project.data.product.domainObject.response.GetAllProductResponseData;
import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;

import java.util.List;

public interface ProductService {

    List<GetAllProductResponseData> getAllProducts();

    ProductResponseData getProductByPid(Integer pid);

    ProductEntity getProductEntityByPid(Integer pid);

    List<ProductResponseData> getProductResponseDataList(List<ProductEntity> productEntityList);

    void paymentProcessingAndDeductStock(List<TransactionProductResponseData> transactionProductResponseDataList);

}
