package com.mensarii.e_khaya_digital_bank.controller;

import com.mensarii.e_khaya_digital_bank.model.SmallMediumMicroEnterprise;
import com.mensarii.e_khaya_digital_bank.service.SmallMediumMicroEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/SMME")
public class SmallMediumMicroEnterpriseController {
    private final SmallMediumMicroEnterpriseService smallMediumMicroEnterpriseService;

    @Autowired
    public SmallMediumMicroEnterpriseController(SmallMediumMicroEnterpriseService smallMediumMicroEnterpriseService) {
        this.smallMediumMicroEnterpriseService = smallMediumMicroEnterpriseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<SmallMediumMicroEnterprise>> findAllSmallMediumMicroEnterprise(){
        return new ResponseEntity<>(smallMediumMicroEnterpriseService.findAllSmallMediumMicroEnterprises(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SmallMediumMicroEnterprise> findSmallMediumMicroEnterprise(@PathVariable("id")Long id){
        return new ResponseEntity<>(smallMediumMicroEnterpriseService.findSmallMediumMicroEnterprise(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SmallMediumMicroEnterprise> addSmallMediumMicroEnterprise (@RequestBody SmallMediumMicroEnterprise smallMediumMicroEnterprise){
        return new ResponseEntity<>(smallMediumMicroEnterpriseService.addSmallMediumMicroEnterprise(smallMediumMicroEnterprise), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SmallMediumMicroEnterprise> updateSmallMediumMicroEnterprise(@PathVariable("id")Long id, @RequestBody SmallMediumMicroEnterprise smallMediumMicroEnterprise){
        smallMediumMicroEnterprise.setId(id);
        SmallMediumMicroEnterprise SMME = smallMediumMicroEnterpriseService.updateSmallMediumMicroEnterprise(smallMediumMicroEnterprise);
        if(SMME != null) {
            return new ResponseEntity<>(SMME, HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSmallMediumMicroEnterprise(@PathVariable("id")Long id){
        smallMediumMicroEnterpriseService.deleteSmallMediumMicroEnterprise(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
