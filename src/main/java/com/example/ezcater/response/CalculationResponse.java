package com.example.ezcater.response;

import lombok.Data;

@Data
public class CalculationResponse {
    String status;
    Integer transactionId;
    Double multiplicationValue;
    Double divisionValue;
}
