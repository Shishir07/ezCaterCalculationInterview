package com.example.ezcater.service;

import com.example.ezcater.dto.InputValues;
import com.example.ezcater.requests.CalculationRequest;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public InputValues validateAndCreateInput(CalculationRequest request) {

        try {
            Double first = Double.valueOf(request.getFirstValue());
            Double second = Double.valueOf(request.getSecondValue());
            return new InputValues(first, second);
        } catch (Exception ex) {
            throw new IllegalArgumentException("The input string should be a double", ex);
        }
    }

    public double multiply(double first, double second) {
        Double result = first * second;
        return Math.round(result * 100.0) / 100.0;
    }

    public double divide(double first, double second) {
        try {
            if (second == 0.0)
                throw new IllegalArgumentException("Exception dividing first" + first + "with second" + second);
            Double result = first / second;
            return Math.round(result * 100.0) / 100.0;
        } catch (Exception ex) {
            throw new IllegalArgumentException("Exception dividing first" + first + "with second" + second);
        }
    }

}
