package com.omnidata.imagereader.Model;

public class BankAccount {
    private String swiftCode;
    private String bankCode;
    private String cityCode;
    private String accountNumber;
    private String ribKey;

    public BankAccount() {
    }



    public BankAccount(String bankCode, String cityCode, String accountNumber, String ribKey) {
        this.bankCode = bankCode;
        this.cityCode = cityCode;
        this.accountNumber = accountNumber;
        this.ribKey = ribKey;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getRibKey() {
        return ribKey;
    }

    public void setRibKey(String ribKey) {
        this.ribKey = ribKey;
    }
}
