package com.fsse2506.project.service.serviceImpl;

import com.fsse2506.project.data.product.domainObject.response.GetAllProductResponseData;
import com.fsse2506.project.data.product.domainObject.response.ProductResponseData;
import com.fsse2506.project.data.product.entity.ProductEntity;
import com.fsse2506.project.data.transactionProduct.domainObject.response.TransactionProductResponseData;
import com.fsse2506.project.exception.product.ProductNotFoundException;
import com.fsse2506.project.exception.transactionProduct.TransactionProductExceedStockException;
import com.fsse2506.project.mapper.product.ProductDataMapper;
import com.fsse2506.project.repository.ProductRepository;
import com.fsse2506.project.service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDataMapper productDataMapper;
    private final ProductRepository productRepository;
    private final Logger logger= LoggerFactory.getLogger(ProductServiceImpl.class);

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
    public List<ProductResponseData> getProductResponseDataList(List<ProductEntity> productEntityList){
        return productDataMapper.toProductResponseDataList(
                productEntityList
        );
    }
    @Transactional
    @Override
    public void paymentProcessingAndDeductStock(List<TransactionProductResponseData> transactionProductResponseDataList){
        try {
//            for (TransactionProductResponseData transactionProductResponseData : transactionProductResponseDataList) {
//
                // Using streams with forEach for side effects (database operations)
                transactionProductResponseDataList.stream()
                        .forEach(transactionProductResponseData -> {
                            try{
                                ProductEntity productEntity = getProductEntityByPid(
                                        transactionProductResponseData.getProductResponseData().getPid()
                                );
                                Integer stock = productEntity.getStock();
                                Integer quantity = transactionProductResponseData.getQuantity();
                                if (stock < quantity) {
                                    throw new TransactionProductExceedStockException(transactionProductResponseData.getTpid());
                                }
                                productEntity.setStock(stock - quantity);
                                productRepository.save(productEntity);
                            } catch(Exception ex){
                                logger.error("Failed to process product {}: {}",transactionProductResponseData.getProductResponseData().getPid(),ex.getMessage());
                                throw ex;// Re-throw to ensure transaction rollback
                            }

            });
        } catch(Exception ex){
            logger.warn("Payment Processing and deduct stock failed: {}",ex.getMessage());
            throw ex;
        }
    }
    @Override
    public List<GetAllProductResponseData> getProductListByCategory(String category) {
            return productDataMapper.toGetAllProductResponseDataList(
                    productRepository.findByCategory(category)
            );
    }
}
