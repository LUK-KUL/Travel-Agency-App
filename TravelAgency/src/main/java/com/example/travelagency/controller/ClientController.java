package com.example.travelagency.controller;

import com.example.travelagency.model.ClientModel;
import com.example.travelagency.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ClientController {
    private final ClientService clientService;

    @GetMapping("/getAllClients")
    public List<ClientModel> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("/addClient")
    public void addClient(@RequestBody ClientModel clientModel) {
        clientService.addClient(clientModel);
    }

    @PostMapping("/editClient")
    public void editClient(@RequestBody ClientModel clientModel) {
        clientService.saveEditedClient(clientModel);
    }

    @PostMapping("/removeClient/{id}")
    public void removeClient(@PathVariable("id") Long id) {
        clientService.removeClient(id);
    }

    @GetMapping("/getClientById/{id}")
    public ClientModel getClientById(@PathVariable("id") Long id) {
        return clientService.findClientById(id);
    }

    @GetMapping("/getClientByEmail/{email}")
    public ClientModel getClientByEmail(@PathVariable("email") String email) {
        return clientService.findClientByEmail(email);
    }

}
