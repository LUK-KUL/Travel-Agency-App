package com.example.travelagency.service;

import com.example.travelagency.model.CountryModel;
import com.example.travelagency.model.PurchaseModel;
import com.example.travelagency.model.TripModel;
import com.example.travelagency.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final TripService tripService;

    public void addPurchase(PurchaseModel purchaseModel) {
        purchaseRepository.save(purchaseModel);
        saveEditedPurchase(calculateTotalCostOfPurchase(purchaseModel, tripService.findTripById(purchaseModel.getTrip().getId())));
        tripService.updateTripChildPlaces(purchaseModel.getId(), purchaseModel.getChildsQuantity());
        tripService.updateTripAdultPlaces(purchaseModel.getId(), purchaseModel.getAdultsQuantity());
        tripService.updateAvailability(purchaseModel.getTrip());
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

    public PurchaseModel calculateTotalCostOfPurchase (PurchaseModel purchaseModel, TripModel tripModel){
        BigDecimal totalCost = tripModel.getAdultPrice().multiply(BigDecimal.valueOf(purchaseModel.getAdultsQuantity()))
                .add(tripModel.getChildPrice().multiply(BigDecimal.valueOf(purchaseModel.getChildsQuantity())));
        purchaseModel.setTotalCost(totalCost);
        return purchaseModel;
    }

}
