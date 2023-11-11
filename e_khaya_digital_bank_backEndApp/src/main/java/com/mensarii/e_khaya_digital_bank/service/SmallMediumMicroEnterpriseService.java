package com.mensarii.e_khaya_digital_bank.service;

import com.mensarii.e_khaya_digital_bank.exception.SmallMediumMicroEnterpriseNotFoundException;
import com.mensarii.e_khaya_digital_bank.model.SmallMediumMicroEnterprise;
import com.mensarii.e_khaya_digital_bank.repository.SmallMediumMicroEnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SmallMediumMicroEnterpriseService {

    private final SmallMediumMicroEnterpriseRepository smallMediumMicroEnterpriseRepository;

    @Autowired
    public SmallMediumMicroEnterpriseService(SmallMediumMicroEnterpriseRepository smallMediumMicroEnterpriseRepository) {
        this.smallMediumMicroEnterpriseRepository = smallMediumMicroEnterpriseRepository;
    }

    public SmallMediumMicroEnterprise addSmallMediumMicroEnterprise(SmallMediumMicroEnterprise smallMediumMicroEnterprise){
        smallMediumMicroEnterprise.setCode(UUID.randomUUID().toString());
        return smallMediumMicroEnterpriseRepository.save(smallMediumMicroEnterprise);
    }

    public List<SmallMediumMicroEnterprise> findAllSmallMediumMicroEnterprises(){

        return smallMediumMicroEnterpriseRepository.findAll();
    }

    public SmallMediumMicroEnterprise updateSmallMediumMicroEnterprise(SmallMediumMicroEnterprise smallMediumMicroEnterprise){
        SmallMediumMicroEnterprise SMME = smallMediumMicroEnterpriseRepository.findById(smallMediumMicroEnterprise.getId()).orElse(null);
        if(SMME != null){
            SMME.setEmail(smallMediumMicroEnterprise.getEmail());
            SMME.setPhone(smallMediumMicroEnterprise.getPhone());
            SMME.setCategory(smallMediumMicroEnterprise.getCategory());
            SMME.setSize(smallMediumMicroEnterprise.getSize());
            return smallMediumMicroEnterpriseRepository.save(SMME);
        }
        return null;
    }

    public void deleteSmallMediumMicroEnterprise(Long id){
        smallMediumMicroEnterpriseRepository.deleteById(id);
    }

    public SmallMediumMicroEnterprise findSmallMediumMicroEnterprise(Long id){
        return smallMediumMicroEnterpriseRepository.findById(id).orElseThrow(
                () -> new SmallMediumMicroEnterpriseNotFoundException("business: "+id+" not found"));
    }
}
