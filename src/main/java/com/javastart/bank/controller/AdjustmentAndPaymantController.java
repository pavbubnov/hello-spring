package com.javastart.bank.controller;

import com.javastart.bank.businessLogic.Adjustment;
import com.javastart.bank.businessLogic.Payment;
import com.javastart.bank.service.AdjustmentAndPaymantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
public class AdjustmentAndPaymantController {

    private final AdjustmentAndPaymantService adjustmentAndPaymantService;

    @Autowired
    public AdjustmentAndPaymantController(AdjustmentAndPaymantService adjustmentAndPaymantService) {
        this.adjustmentAndPaymantService = adjustmentAndPaymantService;
    }

    @PatchMapping("/adjustment/{id}")
    public String getAdjustment(@PathVariable Long id, @Valid @RequestBody Adjustment adjustment) {
        return adjustmentAndPaymantService.adjustAmount(id, adjustment);
    }

    @PatchMapping("payment/{id}")
    public String getPayment(@PathVariable Long id, @Valid @RequestBody Payment payment) {
        return adjustmentAndPaymantService.payBill(id, payment);
    }
}
