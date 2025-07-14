package com.fsse2506.project.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponseDto {
    @JsonProperty
    private Integer pid;
    @JsonProperty
    private String name;
    @JsonProperty
    private String imageUrl;
    @JsonProperty
    private Double price;
    @JsonProperty
    private boolean hasStock;
}
