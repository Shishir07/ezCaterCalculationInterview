package com.example.ezcater.dto;

import lombok.Data;

@Data
public class InputValues {
    Double firstValue;
    Double secondValue;

    public InputValues(Double first, Double second) {
        this.firstValue = first;
        this.secondValue = second;
    }
}
