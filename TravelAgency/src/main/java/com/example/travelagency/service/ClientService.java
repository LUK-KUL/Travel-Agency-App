package com.example.travelagency.service;

import com.example.travelagency.model.ClientModel;
import com.example.travelagency.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public void addClient(ClientModel clientModel) {
        clientRepository.save(clientModel);
    }

    public void saveEditedClient(ClientModel editedClient) {
        clientRepository.save(editedClient);
    }

    public void removeClient(Long id) {
        clientRepository.deleteById(id);
    }

    public List<ClientModel> getAllClients() {
        return clientRepository.findAll().stream().toList();
    }

    public ClientModel findClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public ClientModel findClientByEmail(String email) {
        return clientRepository.findCountryByEmail(email);
    }

}
