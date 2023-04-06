package com.example.demo;

import java.util.HashSet;
import java.util.Set;
import com.example.demo.constants.PaymentMethod;
import com.example.demo.model.Client;
import com.example.demo.model.AddClientResponse;
import com.example.demo.service.ClientService;
import com.example.demo.service.ClientServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class PaymentGatewayApplication {

	public static void main(String[] args) {
		ClientService clientService = new ClientServiceImpl();
		Set<PaymentMethod> paymentMethodSetFlipkart = new HashSet();
		paymentMethodSetFlipkart.add(PaymentMethod.UPI);
		paymentMethodSetFlipkart.add(PaymentMethod.CREDIT_CARD);
		Client clientRequest = Client.builder().Id("client_123").name(com.example.demo.constants.Client.FLIPKART)
				.key("YHV").build();
		AddClientResponse addClientResponse = clientService.addClient(clientRequest);
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			System.out.println("AddClientResponse ::::: " + objectMapper.writer().writeValueAsString(addClientResponse));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		} ;


	}

}
