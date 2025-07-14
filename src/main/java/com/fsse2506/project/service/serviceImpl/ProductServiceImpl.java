package com.fsse2506.project.service.serviceImpl;

import com.fsse2506.project.data.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.entity.ProductEntity;
import com.fsse2506.project.exception.ProductNotFoundException;
import com.fsse2506.project.mapper.ProductDataMapper;
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

    public ProductServiceImpl(ProductDataMapper productDataMapper, ProductRepository productRepository) {
        this.productDataMapper = productDataMapper;
        this.productRepository = productRepository;
    }
    @Override
    public List<ProductResponseData> getAllProducts(){
        return productDataMapper.toProductResponseDataList(
                (List<ProductEntity>) productRepository.findAll()
        );
    }
    @Override
    public ProductResponseData getProductByPid(Integer pid) {
        try {
            return productDataMapper.toProductReponseData(
                    productRepository.findById(pid).orElseThrow(
                            () -> new ProductNotFoundException(pid)
                    )
            );
        } catch (Exception ex) {
            logger.warn("Get Product fail: {}",ex.getMessage());
            throw ex;
        }
    }
}
