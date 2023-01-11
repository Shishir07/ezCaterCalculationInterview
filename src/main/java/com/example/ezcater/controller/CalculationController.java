package com.example.ezcater.controller;


import com.example.ezcater.dto.InputValues;
import com.example.ezcater.requests.CalculationRequest;
import com.example.ezcater.response.CalculationErrorResponse;
import com.example.ezcater.response.CalculationResponse;
import com.example.ezcater.service.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class CalculationController {

    @Autowired
    CalculationService service;

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public ResponseEntity<?> calculate(@RequestHeader("transactionId") int transactionId, @RequestBody CalculationRequest calculationRequest) {
        try {
            InputValues values = service.validateAndCreateInput(calculationRequest);
            Double multiplicationValue = service.multiply(values.getFirstValue(), values.getSecondValue());
            Double divisionValue = service.divide(values.getFirstValue(), values.getSecondValue());
            CalculationResponse response = new CalculationResponse();
            response.setStatus("success");
            response.setTransactionId(transactionId);
            response.setMultiplicationValue(multiplicationValue);
            response.setDivisionValue(divisionValue);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            CalculationErrorResponse response = new CalculationErrorResponse();
            response.setStatus("failure");
            response.setErrorMessage(ex.getMessage());
            response.setTransactionId(transactionId);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
