package com.fsse2506.project.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Integer pid){
        super("Product Not Found: "+pid);
    }
}
