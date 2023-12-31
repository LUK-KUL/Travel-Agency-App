package com.example.travelagency.repository;

import com.example.travelagency.model.TripModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TripRepository extends JpaRepository<TripModel, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE TripModel trip SET trip.childPlaces = :childQuantity WHERE trip.id =:id")
    void updateTripByChildPlaces(@Param("id") Long id, @Param("childQuantity") int childQuantity);

    @Modifying
    @Transactional
    @Query("UPDATE TripModel trip SET trip.adultPlaces = :adultQuantity WHERE trip.id =:id")
    void updateTripByAdultPlaces(@Param("id") Long id, @Param("adultQuantity") int adultQuantity);

    @Modifying
    @Transactional
    @Query("UPDATE TripModel trip SET trip.available = :available WHERE trip.id =:id")
    void updateAvailability(@Param("id") Long id, @Param("available") boolean available);

    /*@Modifying
    @Transactional
    @Query("UPDATE TripModel trip SET trip.isAvailable = :isAvailable WHERE trip.id =:id")
    void updateAvailability(Long id, boolean isAvailable);*/

    @Modifying
    @Transactional
    @Query("UPDATE TripModel trip SET trip.tripLength = :tripLength WHERE trip.id =:id")
    void setTripLength(@Param("id") Long id, @Param("tripLength") Long tripLength);
}
