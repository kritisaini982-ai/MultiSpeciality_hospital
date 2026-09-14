package com.hospital.security.controller;

import com.hospital.security.model.Billing;
import com.hospital.security.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/billings")
@CrossOrigin(origins = "*")
public class BillingController {
    @Autowired
    private BillingRepository billingRepository;

    @GetMapping
    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

@PutMapping("/{id}/pay")
public Billing payBill(@PathVariable Long id) {
    Billing billing = billingRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Bill not found"));
    billing.setStatus("Paid");
    return billingRepository.save(billing);
}

    @PostMapping
    public Billing createBilling(@RequestBody Billing billing) {
        return billingRepository.save(billing);
    }
}