package com.example.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter
@Getter
public class AddClientResponse {
    String message;
    String clientId;

}
