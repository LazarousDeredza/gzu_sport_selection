//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.service.sportManagement;

import com.gzu.sportsselection.model.sportManagement.Insurance;
import com.gzu.sportsselection.repository.sportManagement.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public Insurance getInsurance(Long id) {
        return (Insurance)this.insuranceRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Insurance with id: " + id + " does not exist");
        });
    }
}
