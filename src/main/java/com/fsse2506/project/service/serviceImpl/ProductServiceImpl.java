package com.fsse2506.project.service.serviceImpl;

import com.fsse2506.project.data.product.domainObject.response.GetAllProductResponseData;
import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2506.project.exception.ProductNotFoundException;
import com.fsse2506.project.mapper.product.ProductDataMapper;
import com.fsse2506.project.mapper.product.ProductEntityMapper;
import com.fsse2506.project.repository.ProductRepository;
import com.fsse2506.project.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDataMapper productDataMapper;
    private final ProductRepository productRepository;
    private final Logger logger= LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductEntityMapper productEntityMapper;

    public ProductServiceImpl(ProductDataMapper productDataMapper, ProductRepository productRepository, ProductEntityMapper productEntityMapper) {
        this.productDataMapper = productDataMapper;
        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
    }
    @Override
    public List<GetAllProductResponseData> getAllProducts(){
        return productDataMapper.toGetAllProductResponseDataList(
                (List<ProductEntity>) productRepository.findAll()
        );
    }
    @Override
    public ProductResponseData getProductByPid(Integer pid) {
        try {
            return productDataMapper.toProductResponseData(
                    getProductEntityByPid(pid)
            );
        } catch (Exception ex) {
            logger.warn("Get product by pid failed: {}",ex.getMessage());
            throw ex;
        }
    }
    @Override
    public ProductEntity getProductEntityByPid(Integer pid){
        return productRepository.findById(pid).orElseThrow(
                () -> new ProductNotFoundException(pid)
        );
    }
    @Override
    public List<ProductResponseData> getProductResponseDataList(List<TransactionProductEntity> transactionProductEntityList){
        return productDataMapper.toProductResponseDataList(
                productEntityMapper.toProductEntityList(
                        transactionProductEntityList
                )
        );
    }
}
