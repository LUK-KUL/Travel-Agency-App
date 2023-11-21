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
        TripModel trip = tripService.findTripById(purchaseModel.getTrip().getId());
        purchaseRepository.setTotalCost(purchaseModel.getId(),calculateTotalCostOfPurchase(purchaseModel, trip));
        tripService.updateTripChildPlaces(trip.getId(), purchaseModel.getChildsQuantity());
        tripService.updateTripAdultPlaces(trip.getId(), purchaseModel.getAdultsQuantity());
        tripService.updateAvailability(trip.getId());
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

    public BigDecimal calculateTotalCostOfPurchase (PurchaseModel purchaseModel, TripModel tripModel){
        BigDecimal totalCost = tripModel.getAdultPrice().multiply(BigDecimal.valueOf(purchaseModel.getAdultsQuantity()))
                .add(tripModel.getChildPrice().multiply(BigDecimal.valueOf(purchaseModel.getChildsQuantity())));
        purchaseModel.setTotalCost(totalCost);
        return totalCost;
    }

}
