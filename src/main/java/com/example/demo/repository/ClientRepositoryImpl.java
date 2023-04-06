package com.example.demo.repository;

import java.util.HashMap;
import java.util.Map;
import com.example.demo.model.Client;


public class ClientRepositoryImpl implements IclientRepository {
    Map<String, Client> clientMap = new HashMap();

    public Client addClient (final Client client) {
        clientMap.put(client.getId(), client);
        return clientMap.get(client.getId());
    }

     public Client removeClient(String id) {
         clientMap.remove(id);
         return clientMap.get(id);

    }
    public Client getClient(String id){
       return clientMap.get(id);
    }
}
