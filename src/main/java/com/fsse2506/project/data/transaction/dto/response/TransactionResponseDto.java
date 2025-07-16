package com.fsse2506.project.data.transaction.dto.response;

import com.fsse2506.project.data.transactionProduct.dto.response.TransactionProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
public class TransactionResponseDto {
    private Integer tid;
    private Integer buyerUid;
    private LocalDateTime datetime;
    private String status;
    private BigDecimal total;
    private List<TransactionProductResponseDto> transactionProductResponseDtoList;
}
