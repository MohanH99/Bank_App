
package com.mohancode;
import java.util.UUID;

import static java.lang.Object.*;

public class SBIUser implements BankInterface{
    //attributes
     String name;
    private String accountNo;
    private double balance;
    private String password;
    private double rateOfInterest;

    public SBIUser( String name, double balance, String password) {
        this.name = name;
        this.balance = balance;
        this.password = password;
        //Initialize by bank
        this.rateOfInterest=6.5;
        this.accountNo= String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public String addMoney(int amount) {
        balance= balance+amount;
        return "Updated balance:"+balance;
    }

    @Override
    public String withDrawMoney(int amount, String enterPassword) {
        if(equals(enterPassword,password)){
            if(amount>balance){
                return "Insufficient Money";
            }else{
                balance=balance+amount;
                return "Having Money";
            }

        }else{
            return "Wrong Pssword!";
        }
    }

    private boolean equals(String enterPassword, String password) {
        return true;
    }

    @Override
    public double calculateInterest(int years) {
        return (balance*years*rateOfInterest)/100;
    }
}
