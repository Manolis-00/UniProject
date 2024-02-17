package com.project.model.enums;

import lombok.Getter;

@Getter
public enum PaymentProcessingNetwork {

    VISA("Visa"),

    MASTER_CARD("MasterCard"),

    AMERICAN_EXPRESS("American Express"),

    DISCOVER("Discover"),

    INTERLINK("Interlink"),

    STAR("STAR"),

    ACCEL("Accel"),

    INTERAC("Interac"),

    PULSE("Pulse"),

    JCB("Japan Credit Bureau");

    final String processingNetworkDescription;

    PaymentProcessingNetwork(String processingNetworkDescription) {
        this.processingNetworkDescription = processingNetworkDescription;
    }

}
