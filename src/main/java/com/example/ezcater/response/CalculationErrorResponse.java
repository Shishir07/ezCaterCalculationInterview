package com.example.ezcater.response;

import lombok.Data;

@Data
public class CalculationErrorResponse {
    String status;
    String errorMessage;
    Integer transactionId;
}
