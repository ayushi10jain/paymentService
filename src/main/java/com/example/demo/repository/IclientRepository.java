package com.example.demo.repository;

import com.example.demo.model.Client;


public interface IclientRepository {

    public Client addClient (final Client client);


    public Client removeClient(String id);
    public Client getClient(String id);

}
