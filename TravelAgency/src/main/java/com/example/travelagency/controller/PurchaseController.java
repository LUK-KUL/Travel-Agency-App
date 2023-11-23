package com.example.travelagency.controller;

import com.example.travelagency.model.PurchaseModel;
import com.example.travelagency.service.PurchaseService;
import com.example.travelagency.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final TripService tripService;
    private final TripController tripController;

    @GetMapping("/getAllPurchases")
    public List<PurchaseModel> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @Transactional
    @PostMapping("/addPurchase")
    public void addPurchase(@RequestBody PurchaseModel purchaseModel) {
        purchaseService.addPurchase(purchaseModel);
        tripController.updateTripAvailability(purchaseModel.getId(), tripService.checkIfTripIsAvailable(purchaseModel.getTrip().getId()));
        //tripService.updateAvailability(purchaseModel.getTrip().getId(), tripService.checkIfTripIsAvailable(purchaseModel.getTrip().getId()));
    }

    @PostMapping("/editPurchase")
    public void editPurchase(@RequestBody PurchaseModel purchaseModel) {
        purchaseService.saveEditedPurchase(purchaseModel);
    }

    @PostMapping("/removePurchase/{id}")
    public void removePurchase(@PathVariable("id") Long id) {
        purchaseService.removePurchase(id);
    }

    @GetMapping("/getPurchaseById/{id}")
    public PurchaseModel getPurchaseById(@PathVariable("id") Long id) {
        return purchaseService.findPurchaseById(id);
    }
}
