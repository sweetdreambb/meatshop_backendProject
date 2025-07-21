package com.fsse2506.project.controller;

import com.fsse2506.project.data.product.dto.response.GetAllProductResponseDto;
import com.fsse2506.project.data.product.dto.response.ProductResponseDto;
import com.fsse2506.project.mapper.product.ProductDtoMapper;
import com.fsse2506.project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/public/products")
public class ProductController {
    private final ProductService productService;
    private final ProductDtoMapper productDtoMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllProductResponseDto> getAllProducts(){
        return productDtoMapper.toGetAllProductResponseDtoList(
                productService.getAllProducts()
        );
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto getProductByPid(@PathVariable (name="id") Integer id){
        return productDtoMapper.toProductResponseDto(
                productService.getProductByPid(id)
        );
    }
    @GetMapping("/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllProductResponseDto> getProductListByCategory(@PathVariable (name="category") String cat){
        return productDtoMapper.toGetAllProductResponseDtoList(
                productService.getProductListByCategory(cat)
        );
    }
}
