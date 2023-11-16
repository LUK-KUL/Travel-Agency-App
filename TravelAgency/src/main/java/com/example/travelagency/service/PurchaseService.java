package com.example.travelagency.service;

import com.example.travelagency.model.CountryModel;
import com.example.travelagency.model.PurchaseModel;
import com.example.travelagency.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    public void addPurchase(PurchaseModel purchaseModel) {
        purchaseRepository.save(purchaseModel);
    }

    public void saveEditedPurchase(PurchaseModel editedPurchase) {
        purchaseRepository.save(editedPurchase);
    }

    public void removePurchase(Long id) {
        purchaseRepository.deleteById(id);
    }

    public List<PurchaseModel> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public PurchaseModel findPurchaseById(Long id) {
        return purchaseRepository.findById(id).orElse(null);
    }

}
