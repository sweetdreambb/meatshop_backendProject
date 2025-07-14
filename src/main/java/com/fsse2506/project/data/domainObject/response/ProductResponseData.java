package com.fsse2506.project.data.domainObject.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ProductResponseData {

    private Integer pid;

    private String name;

    private String imageUrl;

    private Double price;

    private boolean hasStock;
}
