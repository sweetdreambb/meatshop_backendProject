package com.fsse2506.project.service;

import com.fsse2506.project.data.domainObject.response.ProductResponseData;

import java.util.List;

public interface ProductService {

    List<ProductResponseData> getAllProducts();

    ProductResponseData getProductByPid(Integer pid);
}
