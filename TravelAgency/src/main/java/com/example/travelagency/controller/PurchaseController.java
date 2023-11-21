package com.example.travelagency.controller;

import com.example.travelagency.model.PurchaseModel;
import com.example.travelagency.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PurchaseController {
    private final PurchaseService purchaseService;

    @GetMapping ("/getAllPurchases")
    public List<PurchaseModel> getAllPurchases(){
       return purchaseService.getAllPurchases();
    }

    @PostMapping("/addPurchase")
    public void addPurchase(@RequestBody PurchaseModel purchaseModel){
        purchaseService.addPurchase(purchaseModel);
    }

    @PostMapping("/editPurchase")
    public void editPurchase(@RequestBody PurchaseModel purchaseModel) {
        purchaseService.saveEditedPurchase(purchaseModel);
    }

    @PostMapping("/removePurchase/{id}")
    public void removePurchase(@PathVariable("id") Long id){
        purchaseService.removePurchase(id);
    }

    @GetMapping("/getPurchaseById/{id}")
    public PurchaseModel getPurchaseById(@PathVariable("id") Long id){
       return purchaseService.findPurchaseById(id);
    }
}
