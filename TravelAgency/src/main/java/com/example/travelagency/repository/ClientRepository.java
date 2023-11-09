package com.example.travelagency.repository;

import com.example.travelagency.model.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {
    @Query("SELECT client FROM ClientModel client WHERE client.email = :email")
    List<ClientModel> findCountryByEmail(String email);
}
