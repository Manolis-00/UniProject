package com.project.model.enums;

import lombok.Getter;

@Getter
public enum PaymentProcessingNetwork {

    ACCEL("Accel"),
    AMERICAN_EXPRESS("American Express"),
    DISCOVER("Discover"),
    INTERAC("Interac"),
    INTERLINK("Interlink"),
    JCB("Japan Credit Bureau"),
    MASTER_CARD("MasterCard"),
    PULSE("Pulse"),
    STAR("STAR"),
    VISA("Visa");

    final String processingNetworkDescription;

    PaymentProcessingNetwork(String processingNetworkDescription) {
        this.processingNetworkDescription = processingNetworkDescription;
    }

}
