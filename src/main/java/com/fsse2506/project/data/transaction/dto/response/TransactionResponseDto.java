package com.fsse2506.project.data.transaction.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2506.project.data.transactionProduct.dto.response.TransactionProductResponseDto;

import com.fsse2506.project.enumeration.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class TransactionResponseDto {
    private Integer tid;
    private Integer buyerUid;
    @JsonFormat(pattern="yyyyMMdd'T'HH:mm:ss")
    private LocalDateTime datetime;
    private Status status;
    private BigDecimal total;
    @JsonProperty(value="items")
    private List<TransactionProductResponseDto> transactionProductResponseDtoList=new ArrayList<>();
}
