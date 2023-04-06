package com.example.demo.service;

import java.util.Objects;
import java.util.Set;
import com.example.demo.constants.MessageConstant;
import com.example.demo.constants.PaymentMethod;
import com.example.demo.exception.ClientNotFoundException;
import com.example.demo.exception.PhonepeException;
import com.example.demo.model.Client;
import com.example.demo.model.AddClientResponse;
import com.example.demo.model.ClientPaymentMethod;
import com.example.demo.model.ClientpaymentModeDistribution;
import com.example.demo.repository.ClientRepositoryImpl;
import com.example.demo.repository.ClientToPaymentModeRepository;
import com.example.demo.repository.IclientRepository;
import com.example.demo.validation.ValidationUtil;
import lombok.extern.log4j.Log4j;


@Log4j
public class ClientServiceImpl implements ClientService{
    IclientRepository clientRepository = new ClientRepositoryImpl();
     ClientToPaymentModeRepository clientToPaymentModeRepository = new ClientToPaymentModeRepository();
    ValidationUtil validationUtil = new ValidationUtil();
    @Override public AddClientResponse addClient(final Client client) {
        AddClientResponse addClientResponse = AddClientResponse.builder().build();
        if(validationUtil.validateRequest(client)){
            addClientResponse.setMessage(MessageConstant.INVALID_REQUEST);
            return addClientResponse;
        }
        Client client1 = storeDataToRepository(client);
        return createResponse(client1, addClientResponse, MessageConstant.CLIENT_SUCCESSFULLY_REGISTERED);
    }

    @Override public AddClientResponse removeClient(final String clientId) {
        Client client1 = clientRepository.removeClient(clientId);
        clientToPaymentModeRepository.removeClient(clientId);
        return createResponse(client1, AddClientResponse.builder().build(),
                MessageConstant.CLIENT_SUCCESSFULLY_DELETED);

    }

    @Override public AddClientResponse hasClient(final String clientId) {
        Client client = clientRepository.getClient(clientId);
        if(Objects.nonNull(client)){
           return createResponse(client, AddClientResponse.builder().build(),
                    "");
        }
        throw new PhonepeException("Client Not found");
    }

    @Override public ClientPaymentMethod getAllPaymentMethodsSupportedByClient(final String clientId) {
        Set<PaymentMethod> paymentMethodSet = clientToPaymentModeRepository.getPaymenytMethods(clientId);
        if(Objects.nonNull(paymentMethodSet)){
            ClientPaymentMethod clientPaymentMethod = ClientPaymentMethod.builder().clientId(clientId)
                    .paymentMethodSet(paymentMethodSet).build();
            return clientPaymentMethod;
        }
        throw new PhonepeException("Either client or Payment Method to that client does not exist");
    }

    private AddClientResponse createResponse(final Client client1,AddClientResponse addClientResponse, String message) {
        addClientResponse.setClientId(client1.getId());
        addClientResponse.setMessage(message);
        return addClientResponse;
    }

    public Client storeDataToRepository(Client client){
        Client client1 = clientRepository.addClient(client);
        clientToPaymentModeRepository.addpaymentmethodsToClient(client.getId(),
                client.getPaymentMethodSet());
        return client1;
    }

    public ClientPaymentMethod removePaymentMethodsFromClient(String clientId, Set<PaymentMethod> paymentMethods){
        Client client1 = clientRepository.getClient(clientId);
        if(Objects.isNull(client1)){
            throw new ClientNotFoundException();
        }
        Set<PaymentMethod> paymentMethodSet = clientToPaymentModeRepository.removePaymentMethodsFromClient(clientId,
                paymentMethods);
        ClientPaymentMethod clientPaymentMethod = ClientPaymentMethod.builder().clientId(clientId)
                .paymentMethodSet(paymentMethodSet).build();
        return clientPaymentMethod;

    }

    @Override public ClientpaymentModeDistribution getRoutingDistribution(final String clientId) {
        Client client1 = clientRepository.getClient(clientId);
        Set<PaymentMethod> paymentMethodSet = clientToPaymentModeRepository.getPaymenytMethods(clientId);

        for(PaymentMethod paymentMethod : paymentMethodSet){

        }
    }

}
