package com.example.emicalculator.models;

import java.io.Serializable;

public class EMI implements Serializable {
    int month, principal, interest, t_payment, balance;

    public EMI(int month, int principal, int interest, int t_payment, int balance) {
        this.month = month;
        this.principal = principal;
        this.interest = interest;
        this.t_payment = t_payment;
        this.balance = balance;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public int getInterest() {
        return interest;
    }

    public void setInterest(int interest) {
        this.interest = interest;
    }

    public int getT_payment() {
        return t_payment;
    }

    public void setT_payment(int t_payment) {
        this.t_payment = t_payment;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
