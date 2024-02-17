package com.project.model.enums;

import lombok.Getter;

@Getter
public enum Bank {

    ETHNIKI("National Bank of Greece"),

    PIRAEUS("Piraeus Bank"),

    HSBC("The Hongkong and Shanghai Banking Corporation"),

    EUROBANK("Euro-bank"),

    OPTIMA("Optima Bank"),

    JP_MORGAN("JP Morgan"),

    ALPHA("Alpha Bank"),

    PANCRETAN("Pancretan"),

    CITIBANK("Citibank");

    final String bankName;

    Bank(String bankName) {
        this.bankName = bankName;
    }
}
