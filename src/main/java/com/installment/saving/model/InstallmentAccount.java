package com.installment.saving.model;

public class InstallmentAccount {
    private int id;
    private int tenor;
    private double first_deposit;
    private double monthly_deposit;
    private String purpose;

    public InstallmentAccount() {
        //Empty Constructor
    }

    public InstallmentAccount(int id, int tenor, double first_deposit, double monthly_deposit, String purpose) {
        this.id = id;
        this.tenor = tenor;
        this.first_deposit = first_deposit;
        this.monthly_deposit = monthly_deposit;
        this.purpose = purpose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public double getFirst_deposit() {
        return first_deposit;
    }

    public void setFirst_deposit(double first_deposit) {
        this.first_deposit = first_deposit;
    }

    public double getMonthly_deposit() {
        return monthly_deposit;
    }

    public void setMonthly_deposit(double monthly_deposit) {
        this.monthly_deposit = monthly_deposit;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}