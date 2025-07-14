package com.fsse2506.project.controller;

import com.fsse2506.project.data.dto.response.ProductResponseDto;
import com.fsse2506.project.mapper.ProductDtoMapper;
import com.fsse2506.project.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;
    private final ProductDtoMapper productDtoMapper;
    public ProductController(ProductService productService, ProductDtoMapper productDtoMapper){
        this.productService=productService;
        this.productDtoMapper = productDtoMapper;
    }
    @GetMapping("/public/products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProducts(){
        return productDtoMapper.toProductResponseDtoList(
                productService.getAllProducts()
        );
    }
    @GetMapping("/public/products/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto getProductByPid(@PathVariable (name="id") Integer pid){
        return productDtoMapper.toProductResponseDto(
                productService.getProductByPid(pid)
        );
    }
}
