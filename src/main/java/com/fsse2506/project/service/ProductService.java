package com.fsse2506.project.service;

import com.fsse2506.project.data.product.domainObject.response.GetAllProductResponseData;
import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.product.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<GetAllProductResponseData> getAllProducts();

    ProductResponseData getProductByPid(Integer pid);

    ProductEntity getProductEntityByPid(Integer pid);
}
